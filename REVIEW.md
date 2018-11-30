# Things I like about the codebase

- Using as maven project
- Using as springboot application
- Separation among web code and services, logic, domain code
- Use of unit testing allows refactor the project to improve it.
- Good test coverage.

# Problems/suggested improvements

- Poor package organization. Needs improve the separation like domain, services, controllers, etc.
- Needs clean code: some forgotten _semicolons_, _imports with *_.
- Abuse of nested loops, maybe refactor with design patterns.
- No javadoc.
- Avoid returns _true/false_ sentences. Better using of conditional or ternary sentences
    - `BoarLogic#validateCell()` always returns true   
    - `BoarLogic#validateColumn()` always returns true   
- `BoarLogic#validateDigits()` never throws an `SudokuValidationException`   
- Control some nulls from params with `Optional` to avoid `NullPointerExceptions`
- Improvement: Use a ATDD syntax like _given...when...then_ in the tests to self documentation.
- Refactor nested conditions because Java use "_short circuit_" to evaluate logical operators.
- Maybe too cyclomatic complexity due to nested loops and nested conditions.

# Highest priority improvement

- A big issue (probably) is about `BoardLogic` class and _"validate"_ methods. Each use nested loops and all of them are processing in sequence over the same thread. So in a concurrent context and with more data it could be possible to suffer a big delay. So a good practice should be parallelize across several threads. I said probably because in local, actual vs refactored code is faster. So it was necessary do it some of stress test to check results.
- Another issue (maybe personal) is about modify a collection or object by reference into a method. I consider that is better change is by value or make a inmutable object and work with copies.  
- Use native components from spring project, like:
    - Controllers, RestControllers
    - Exception Interceptors
    - `@Autowired` and `@Component` 
    - Use Inversion of Control instead of calling constructor using "`new`".
- Use `Interfaces` for `@Services` and `@Repositories` to allow extensibility and low coupling
- Use external configuration throught properties or yaml files
- Use of external libraries for better coding like:
    - **Lombok**: better and clean code for pojos. Builder pattern also.
    - **Jackson**: native mapper to json in springboot that with Spring Restcontroller allows remove jersey mapper.
- If it was possible use Java 8. It should be good practice converts array to streams to use lambdas to improve the code.
- Write javadoc comments to avoid technical debt, or write self-descriptive method names.
- Remove static objects initialization from Components.
    - I understand that could be interesting to have an in memory database like, but because that @Components (Controllers, services and repositories) are Singletons it could be dangerous that they contain static references to objects that could be shared among http requests with several clients in a production ready software.
- Remove loops for 2D array initialization, better using easy initialization.    
- Control null params passed by http with Spring assertions or java Optionals  

# Colophon

I have not refactored the entire project, only the relevant parts. Remove errors and always supported by tests. Tests continue passing in green.

A deepest refactor must include chage Jersey components by `@RestControllers` and `ExceptionInterceptors` and refactoring test also to use `@Before` methods to reuse some initialization code, and document the methods.

In a production ready environment I'd take care about concurrency of some task, remove static parts and I'd use native SpringBoot components for a better integration, extensibility and testing with third parts.