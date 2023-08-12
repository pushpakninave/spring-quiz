# spring-quiz
A quiz backend with rest
> Difference between IDENTITY and SEQUENCE 
https://www.sqlshack.com/difference-between-identity-sequence-in-sql-server/

> Why I used GenerationType-> SEQUENCE instead of IDENTITY ?

Quoting : http://en.wikibooks.org/wiki/Java_Persistence/Identity_and_Sequencing:
Identity sequencing uses special IDENTITY columns in the database to allow the database to automatically assign an id to the object when its row is inserted. Identity columns are supported in many databases, such as MySQL, DB2, SQL Server, Sybase and Postgres. Oracle does not support IDENTITY columns but they can be simulated through using sequence objects and triggers.

so I prefer to use SEQUENCE instead
Sequence objects use special database objects to generate ids. Sequence objects are only supported in some databases, such as Oracle, DB2, and Postgres. Usually, a SEQUENCE object has a name, an INCREMENT, and other database object settings. Each time the .NEXTVAL is selected the sequence is incremented by the INCREMENT.


> About update and delete methods in questionController ?

Quoting : https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-requestmapping.html
@DeleteMapping and @PutMapping are the two mappings defined by me which aren't included in the tutorial. These mappings are basically to additionally provide delete and update functionality in the form of endpoints. This can be tested through postman, swagger or any other api testing plateform.

> About @ResponseEntity and @RequestEntity
This was 

> @RequestParam and @PathVariable difference

> Optional<> used in getQuizQuestions method in QuizService

A container object which may or may not contain a non-null value. If a value is present, isPresent() returns true. If no value is present, the object is considered empty and isPresent() returns false.

Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (returns a default value if no value is present) and ifPresent() (performs an action if a value is present).