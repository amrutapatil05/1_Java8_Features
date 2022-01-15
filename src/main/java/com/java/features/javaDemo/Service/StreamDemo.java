package com.java.features.javaDemo.Service;

import com.java.features.javaDemo.Beans.Employee;
import com.java.features.javaDemo.Beans.Student;

import java.util.*;

public class StreamDemo {

    public static void main(String a[]){
    //ListOps.iterateList();
        //ListOps.defaultIntListSort();
        //ListOps.sortByNameTraditionally();
        //ListOps.sortByNameOrSalaryWithStream();
  ListOps.reduceSalaryForPuneLocation();

        // MapOps.iterateMap();
        //MapOps.sortMap_Traditionally();
        // MapOps.sortTreeMap_traditionally();
        //MapOps.sortMap_stream("desc");
    }
}

class EmpNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ListOps {
    public static ArrayList<Employee> getEmlpList() {
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee("1", "Ram", 100000, "Pune"));
        empList.add(new Employee("2", "Tony", 20000, "Pune"));
        empList.add(new Employee("3", "Richard", 55000, "Mumbai"));
        empList.add(new Employee("4", "Boby", 35000, "Mumbai"));
        empList.add(new Employee("5", "Shyam", 50000, "Delhi"));
        empList.add(new Employee("6", "Mark", 60000, "Bangalore"));
        return  empList;
    }

    public static void iterateList() {
        List list = Arrays.asList("asd", "bsd", "csdf", "adf", "fhk");
        list.stream().filter(t -> t.toString().startsWith("a")).forEach(t -> System.out.println(t));
    }
    public static void defaultIntListSort() {
        List lst = Arrays.asList(12,21,13,14,5);
        System.out.println("Before Sort : "+ lst);
        Collections.sort(lst);
        System.out.println("After Sort with Collections.sort: "+ lst);
        Collections.reverse(lst);
        System.out.println("After reverse Sort with Collections.reverse: "+ lst);
        System.out.println("With stream Default(asc) sort : ");
        lst.stream().sorted()
                .forEach(t -> System.out.println(t));
        System.out.println("With stream Reverse sort : ");
        lst.stream().sorted(Collections.reverseOrder())
                .forEach(t -> System.out.println(t));
    }
    public static void sortByNameTraditionally () {
        System.out.println("*****************By Name Sorting*************");
        ArrayList<Employee> empList = getEmlpList();
        System.out.println("Original list: "+ empList);
        Collections.sort(empList, new EmpNameComparator());
        System.out.println("Sorted(asc) with external comparator class: "+ empList);
        Collections.sort(empList, new EmpNameComparator().reversed());
        System.out.println("Sorted(desc) with external comparator class: "+ empList);
        Collections.sort(empList, (obj1, obj2) -> obj1.getName().compareTo(obj2.getName()));
        System.out.println("Sorted(asc) with lambda expr instead of external comparator: "+ empList);
        Collections.sort(empList, (obj1, obj2) -> obj2.getName().compareTo(obj1.getName()));
        System.out.println("Sorted(asc) with lambda expr instead of external comparator: "+ empList);
    }
    public static void sortByNameOrSalaryWithStream(){
        ArrayList<Employee> empList = getEmlpList();
        System.out.println("Original list: "+ empList);

        System.out.println("Sort(asc) by name");
        empList.stream().sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
        System.out.println("Sort(desc) by name");
        empList.stream().sorted(Comparator.comparing(Employee::getName).reversed())
                .forEach(System.out::println);
        System.out.println("Sort(asc) by salary");
        empList.stream().sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
        System.out.println("Sort(desc) by salary");
        empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
        //if(sortByAttribute.equalsIgnoreCase())
    }
    public static void reduceSalaryForPuneLocation(){
    ArrayList<Employee> empList = getEmlpList();
        System.out.println("original list: "+ empList);
        Long end = (long)0;
        Long start = (long)0;

        int puneSalarySum = empList.stream()
                .filter(emp -> emp.getCity().equalsIgnoreCase("Pune"))
                .mapToInt(e -> e.getSalary())
                .reduce(Integer::sum)
                .getAsInt();

        System.out.println("puneSalarySum: "+puneSalarySum);
        start =System.currentTimeMillis();
        double puneAvgSalary = empList.stream()
                .filter(emp -> emp.getCity().equalsIgnoreCase("Pune"))
                .mapToInt(e -> e.getSalary())
                .average()
                .getAsDouble();

        end =System.currentTimeMillis();
        System.out.println("puneAvgSalary: "+puneAvgSalary+ " with sequential stream in time: " + (end-start) + " (ms)");

        start =System.currentTimeMillis();
        double puneAvgSalary_parallelStream = empList.parallelStream()
                .filter(emp -> emp.getCity().equalsIgnoreCase("Pune"))
                .mapToInt(e -> e.getSalary())
                .average()
                .getAsDouble();
        end =System.currentTimeMillis();
        System.out.println("Avg Salary : "+ puneAvgSalary_parallelStream + " with parallel stream in time: " + (end-start) + " (ms)");
    }
}

class MapOps {
    public static Map<Integer, String > getPrimitiveMap() {
        Map<Integer, String> map = new HashMap();

        map.put(1, "Acvd");
        map.put(2, "Bds");
        map.put(3, "Cfds");
        map.put(4, "Dfd");
        map.put(5, "Asfd");
        return map;
    }
    public static Map<Employee, String> getObjectMap(String mapType) {
        if(mapType.equalsIgnoreCase("hashmap")) {
            Map<Employee, String> employeeMap = new HashMap<>();
            employeeMap.put(new Employee("1", "Ram", 100000, "Pune"), "English");
            employeeMap.put(new Employee("2", "Genni", 500000, "Bangalore"), "History");
            employeeMap.put(new Employee("3", "Kevin", 300000, "Kolkata"), "Science");
            employeeMap.put(new Employee("4", "Ross", 1500000, "Pune"), "Maths");
            employeeMap.put(new Employee("5", "Anathony", 800000, "Mumbai"), "Chemistry");
            return employeeMap;
        }
         if(mapType.equalsIgnoreCase("treemap")){
            Map<Employee, String> employeeMap = new TreeMap<>();
            employeeMap.put(new Employee("1", "Ram", 100000, "Pune"), "English");
            employeeMap.put(new Employee("2", "Genni", 500000, "Bangalore"), "History");
            employeeMap.put(new Employee("3", "Kevin", 300000, "Kolkata"), "Science");
            employeeMap.put(new Employee("4", "Ross", 800000, "Pune"), "Maths");
            employeeMap.put(new Employee("5", "Anathony", 600000, "Mumbai"), "Chemistry");
            return employeeMap;
        }
         return null;
    }
    public static void iterateMap() {
        Map<Integer, String> map = getPrimitiveMap();
        System.out.println("Map elements with key%2 == 0");
        map.keySet().stream()
                .filter(t -> (int)t % 2 == 0)
                .forEach(t -> System.out.println(t));

        System.out.println("Map entries where value starts with 'A'");
        map.values().stream()
                .filter(v -> v.toString().startsWith("A"))
                .forEach(t -> System.out.println(t));

        System.out.println("Map entrySet with values starts with 'Z'");
        map.entrySet().stream().filter( t -> t.getValue().startsWith("Z"))
                .forEach(System.out::println);

    }
    public static void sortMap_Traditionally() {
        Map<Employee, String> employeeMap = getObjectMap("hashmap");
        System.out.println("Original Map: " + employeeMap);
        //Traditional way: convert map to list and apply Collections.sort()
        List<Map.Entry<Employee, String>> empMapToList = new ArrayList<>(employeeMap.entrySet());
        System.out.println("Map converted to list : " + empMapToList);
        Collections.sort(empMapToList, (entry1, entry2) -> entry1.getKey().getName().compareTo(entry2.getKey().getName()));
        System.out.println("Sorted map->list by employee Name" + empMapToList);
        Collections.sort(empMapToList, (entry1, entry2) -> entry2.getKey().getName().compareTo(entry1.getKey().getName()));
        System.out.println("Sorted map->list Desc by employee Name" + empMapToList);
    }
    public static void sortTreeMap_traditionally() {
        Map<Employee, String> empMap = getObjectMap("treemap");
        System.out.println("As Comparator already added while creating Map, list is already in sorted order by Salary Ascending");
        System.out.println("Original Map : "+ empMap);
    }
    public static void sortMap_stream(String order) {
        Map<Employee, String> employeeMap = getObjectMap("hashmap");
        System.out.println("Original Map: " + employeeMap);

        if(order.equalsIgnoreCase("desc"))
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
                .forEach(System.out::println);
        else
            employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)))
                    .forEach(System.out::println);
    }
}