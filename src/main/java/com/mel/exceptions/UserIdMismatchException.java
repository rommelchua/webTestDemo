package com.mel.exceptions;

import com.mel.model.User;

public class UserIdMismatchException extends RuntimeException {
  private static final long serialVersionUID = 1525748793434602280L;

public UserIdMismatchException(User user, Long userId) {
    super("The userId parameter userId=" + Long.toString(userId) + " does not match user object's id user.getObjectId()=" + user.getId());
  }
}
