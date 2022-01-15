# 1_Java8_Features
1. Lambda expression: To represent anonymous function (i.e. only abstract method of functional interface) //(parameters)
   -> {Body};
2. Functional interface: 
   1. Interface contains only one abstract method and multiple default & static methods. Existing
   2. Functional interfaces before java8: Runnable(run()), Callable(call()), Comparable(compareTo()), Comparator(compare())
   3. Custom functional interfaces can be created using @FunctionalInterface annotation. 
   4. Need: To avoid others to add additional abstract method in future 
   5. Java8 provided functional interfaces: Consumer, Predicate, Supplier
      1. Consumer: void accept(T t) // when we want to accept object, perform operation & no need return anything. e.g. forEach always
            accept consumer functional interface 
      2. Predicate: boolean test(T t) // used for conditional check, e.g filter always
            accepts predicate functional interface 
      3. Supplier: T get()// no input but output is expected e.g. orElseGet always
            accepts Supplier functional interface
3. Stream:
   1. Intermediate ops: filter, sorted, map, flatMap, distinct, findAny, findFirst 
   2. Terminal Ops: forEach, collect,
   
4. List/Map sorting ways: 
   1. With comparator: collections.sort(list, comparatorObj); 
   2. Lambda instead of comparator class: collections.sort(list, (obj1, obj2) -> obj1.getName().compareTo(obj2.getName())
   3. Stream api : list.stream().sorted(Comparator.comparing(Employee::getName().reversed())).forEach(System.out::println)
   4. map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName().reversed())))
      .forEach(System.out::println)

5. Map & FlatMap:
   1. Map: One to one mapping, accepts stream & returns stream. Used for data transformation 
   2. FlatMap(Map+flattering): One to many mapping, used for data transformation + flattering, accept stream of stream as input and returns
      single/flattered stream as output Use map to deal with simple arrayList, flat map for list of list.

6. Optional: To check unpredictable null pointer exception. Ways: Optional.empty() //for empty value, Optional.of(param)
   // if sure abt param availability else this will throw nullPointerEx Optional.ofNullable(param) // if null returns
   empty optional else gives value Get Value out of optional:
   if(optionalVar.isPresent()) optionalVar.get(); optionalVar.orElse("DefaultValue"); optionalVar.orElseThrow(customEx);
   Optional methods: .orElse, orElseGet, isPresent, get, map, stream findAny returns optional Note: It is recommended to
   add Optional as return type of all getters of pojo

7. Map & Reduce: Transform & aggregate the stream data Reduce(Identity, Accumulator) // identity: initial value,
   Accumulator: aggregate function

8. ParallelStream:  all threads distributed to all available cores. Order of execution is random. Use .parallelStream or
   .parallel() of stream Sequential stream: all threads executed by single core. Order of execution is fixes/sequential


# Features from Java 9 released in 2017 and Java 17 released in September 2021.
- Enhanced Switch
- New instanceof
- Type Inference (var)
- Records
- Text Blocks : with """
- Sealed Classes
- of for Collections
- Meaningful NullPointerException

# Basic commands of Spring-boot

1. Ways to create app 1.1 Using spring initializer: https://start.spring.io/
   1.2 Using Command line:
   mvn archetype:generate -DgroupId={project-packaging} -DartifactId={project-name}
   -DarchetypeArtifactId={maven-template} -DinteractiveMode=false mvn archetype:generate -DgroupId=com.java.features
   -DartifactId=java-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

   1.3 With IDE File-> new-> project-> Maven -> Select-ArchType-quickstart-> add grpId/ArtifactId

    1. Packaging/Build steps:
       # compile the project and generate target folder
       mvn compile
       # build the maven project and installs it into local maven repository
       mvn clean install
       # Skip tests
       mvn clean install -Dmaven.test.skip=true package
       # execute the project Note: You cannot execute the maven project with Exec plugin without the compile step. Since this step checks the target directory for the classes to call.
       mvn exec:java -Dexec.mainClass=com.mycompany.App
       # Run test Or run single test
       mvn test Or mvn test -Dtest=com.mycompany.AppTest#testMethod

2. Ways to run app  : java -jar {jar path} 