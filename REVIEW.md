# Things I like about the codebase

- Using as maven project
- Using as springboot application
- Separation among web code and services, logic, domain code
- Use of unit testing allows refactor the project to improve it.

# Problems/suggested improvements

- Poor package organization. Need improve the separation like domain, services, controllers, etc.
- Needs clean code: some _semicolons_, _imports with *_.
- Abuse of nested loops.
- No javadoc.
- Avoid returns _true/false_ sentences


# Highest priority improvement

- Use native components from spring project, like:
    - Controllers, RestControllers
    - Exception Interceptors
    - `@Autowired` and `@Component` 
    - Use Inversion of Control to avoid `new` to call constructor.
- Use external configuration throught properties or yaml files
- Use of external libraries for better coding like:
    - **Lombok**: better and clean code for pojos. Also builder pattern
    - **Jackson**: native mapper to json in springboot that with Spring Restcontroller allows remove jersey mapper.
- If it was possible use Java 8. It should be good practice converts array to streams to use lambdas to improve the code.
- Write javadoc comments to avoid technical debt.
- Refactor the code with some design patterns (_strategy_, _command_) 
- Refactor the code with some refactor patterns (replace object by method, replace array by object, and so on) 
    
    