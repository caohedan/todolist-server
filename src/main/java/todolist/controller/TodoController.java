package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import todolist.model.Todo;
import todolist.service.TodoService;


@RestController
@RequestMapping("/todos")
public class TodoController {

  private final TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/{userId}")
  public Page<Todo> getTodosByUserId(@RequestParam(name = "page_size", defaultValue = "10") int pageSize,
      @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
      @PathVariable  String userId) {
    return todoService.getTodosByUserId(pageNum - 1, pageSize, userId);
  }

  @PostMapping("")
  public ResponseEntity addTodo(@RequestBody Todo todo) {
    todoService.addTodo(todo);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity modifyTodo(@PathVariable Long id, @RequestBody Todo todo) {

    if (todoService.modifyTodo(id, todo.getContext())) {
      return ResponseEntity.status(HttpStatus.OK).build();
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
