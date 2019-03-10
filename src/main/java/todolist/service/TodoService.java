package todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.model.Todo;
import todolist.repository.TodoRepository;

@Service
public class TodoService {

  private final TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Page<Todo> getTodosByUserId(int pageNum, int pageSize, String userId) {

    Sort sort = new Sort(Sort.Direction.DESC, "creTime");
    return todoRepository.findByUserId(userId, new PageRequest(0, 99999, sort));
  }

  @Transactional
  public void addTodo(Todo todo) {
    todoRepository.save(todo);
  }

  @Transactional
  public boolean modifyTodo(Long contextId, String context) {
    if (todoRepository.findByContextId(contextId) != null) {
      todoRepository.updateTodo(contextId,context);
      return true;
    } else {
      return false;
    }
  }

  @Transactional
  public void deleteTodo(Long contextId) {
    todoRepository.deleteByContextId(contextId);
  }
}
