package business.control.validators;

import exceptions.UserException;
import business.model.User;

public interface IUserValidator
{
	void validate(User user) throws UserException;
}