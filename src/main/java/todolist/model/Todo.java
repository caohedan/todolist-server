package todolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity //声明一个实体，用的是Java规范下的注解
@Table(name = "todo") //映射的表名称
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long contextId;

  private String userId;
  private String context;
  private String creTime;

  public Long getContextId() {
    return contextId;
  }

  public void setContextId(Long contextId) {
    this.contextId = contextId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getCreTime() {
    return creTime;
  }

  public void setCreTime(String creTime) {
    this.creTime = creTime;
  }
}