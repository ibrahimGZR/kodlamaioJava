package core.utils.business;

import core.utils.results.Result;

public class BusinessRules {

	public static Result run(Result... logics) {
		for (Result logic : logics) {
			if (!logic.isSuccess()) {
				return new Result(false, logic.getMessage());
			}
		}
		return new Result(true);

	}
}
