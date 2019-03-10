package todolist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import todolist.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {

  Page<Todo> findByUserId(String title, Pageable pageable);


  Todo findByContextId(Long id);

  //
//    @Modifying
//    void deleteByWhatsNewId(Long id);
//
  @Modifying
  @Query(value = "update todo set context=:context where context_id=:contextId", nativeQuery = true)
  int updateTodo(@Param("contextId") Long contextId, @Param("context") String context);

  void deleteByContextId(Long contextId);
}
