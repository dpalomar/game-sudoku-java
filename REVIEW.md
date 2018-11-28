# Things I like about the codebase

- Using as maven project
- Using as springboot application
- Separation among web code and services, logic, domain code
- Use of unit testing allows refactor the project to improve it.

# Problems/suggested improvements

- Poor package organization. Need improve the separation like domain, services, controllers, etc.
- Needs clean code: some forgotten _semicolons_, _imports with *_.
- Abuse of nested loops.
- No javadoc.
- Avoid returns _true/false_ sentences. Better using of conditional sentences
- Control some nulls from params with `Optional` to avoid `NullPointerExceptions`

# Highest priority improvement

- Use native components from spring project, like:
    - Controllers, RestControllers
    - Exception Interceptors
    - `@Autowired` and `@Component` 
    - Use Inversion of Control to avoid "`new`" to call constructor.
- Use `Interfaces` for `@Services` and `@Repositories` to allow extensibility and low coupling
- Use external configuration throught properties or yaml files
- Use of external libraries for better coding like:
    - **Lombok**: better and clean code for pojos. Builder pattern also.
    - **Jackson**: native mapper to json in springboot that with Spring Restcontroller allows remove jersey mapper.
- If it was possible use Java 8. It should be good practice converts array to streams to use lambdas to improve the code.
- Write javadoc comments to avoid technical debt.
- Remove static objects initialization from Components.
    - I understand that could be interesting to have an in memory database like, but because that @Components (Controllers, services and repositories) are Singletons it could be dangerous that they contain static references to objects that could be shared among http requests with several clients in a production ready software.
- Remove loops for 2D array initialization, use easy initialization.    
    