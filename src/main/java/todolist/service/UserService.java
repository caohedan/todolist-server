package todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist.model.User;
import todolist.repository.UserRepository;
import todolist.util.MD5Util;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public boolean login(User user) {
    return userRepository.findByUserIdAndPassword(user.getUserId(), MD5Util.md5(user.getPassword())) != null;  }
}
