package GroupingByCollector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Grouping {
	public static void main(String[] args) {
		Grouping obj = new Grouping();
        obj.test();
    }
	
	private void test(){
		List<Person> persons = Arrays.asList(
				new Person("Danang", "Cilacap"),
				new Person("Indra", "Purwokerto"),
				new Person("Kurniawan","Cilacap"));
	
		 Map<String, List<Person>> collect = 
					persons.stream().collect(Collectors.groupingBy(Person::getCity));
		        System.out.println(collect);
		        
		        //multi-level reduction, toSet()
		        Map<String, Set<String>> collect1 = 
					persons.stream().collect(Collectors.groupingBy(Person::getCity,
		                Collectors.mapping(Person::getName, Collectors.toSet())));
		        System.out.println(collect1);

		        //multi-level reduction, toList()
		        Map<String, List<String>> collect2 = 
					persons.stream().collect(Collectors.groupingBy(Person::getCity,
		                Collectors.mapping(Person::getName, Collectors.toList())));
		        System.out.println(collect2);		        
	}
}
