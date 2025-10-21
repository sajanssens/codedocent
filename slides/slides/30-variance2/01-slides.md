## Variance
<!-- .slide: class="is-fancy2" -->


---

### Variance
- Given the generic type `C<T>`
  - `C` is a _container_ for `T`.

> How does a generic type behave when used as a method parameter?

---
 
### Subtypes and generics
Given: `Developer` is a subtype of `Employee`.

Question: is `List<Developer>` is a subtype of `List<Employee>` too?

---

### Subtypes and generics

- Given this method:
    ```java
    class Finance {  
       void payAll(List<Employee> e) { /*...*/ }	
    }
    ```
- Are these calls allowed? <!-- .element: class="fragment" -->
	```java
    f.payAll(employees);  // employees is a  List<Employee>
    f.payAll(developers); // developers is a List<Developers>
    ```
   - Your gut feeling says..?
- No ❌! The second call gives: <!-- .element: class="fragment" -->
  ```console
  java: incompatible types: 
     java.util.List<Developer> cannot be converted to 
     java.util.List<Employee>
  ```
- So: <!-- .element: class="fragment" -->
  - `List<Developer>` is NOT a subtype of `List<Employee>`!	
  - `List<T>` is **invariant**


---

### Subtypes and generics
- Why is that?  
- Because <!-- .element: class="fragment" --> we can **do things** with the contents: 
	```java [2|6]
	void payAll(List<Employee> es) {
 		for (Employee e : es) {     // read Employee ✅
 			e.pay();    
 		}	   		
  
		es.add(new ProductOwner());  // write Employee ✅
	}
	```
   - perfectly valid code in this context... <!-- .element: class="fragment" -->
- If <!-- .element: class="fragment" --> calling `f.payAll(developers)` was allowed...
  - ... a <!-- .element: class="fragment" --> `ProductOwner` could get added to a group of developers!
  - ... would <!-- .element: class="fragment" --> generate a lot of spaghetti 🍝🍝🍝🍝

---

### Subtypes and generics
- But developers need their salary too... 🍕🍕🍕
- So in <!-- .element: class="fragment" --> **this** case
  - we want to be able to **pass employees and developers**
  - we don't care that we can't **write** to the list
  - we want `List<Developer>` to be a subtype of `List<Employee>`

---

### Covariant
- We make the parameter type _covariant_
	```java [1|2|6|]
	void payAll(List<? extends Employee> es) { 
		for (Employee e : es) {         // read Employee ✅
			e.pay();    
		}	   		
	
		// es.add(new ProductOwner());  // write Employee ❌
	}
	```
- As <!-- .element: class="fragment" --> a consequence
  - write is _not_ allowed anymore, `es` is producing only
  - these <!-- .element: class="fragment" --> calls _are_ allowed now: 
      ```java
      f.payAll(employees);   ✅
      f.payAll(developers);  ✅
      ```
- the parameter <!-- .element: class="fragment" --> `es` is 
  - **producing** content
  - **at most** a list of employees or more specific

---

### Contravariant
- We can also make the parameter type _contravariant_
	```java [1|2|6|]
	void scaleUp(List<? super Employee> team) { 
		for (Object o : team) {        // read Employee ❌ (Object ✅)
			log(o.toString());
		}	   		
	
		team.add(new ProductOwner());  // write ✅
	}
	```
- As <!-- .element: class="fragment" --> a consequence 
  - we read an `Object`, not an `Employee`
  - these <!-- .element: class="fragment" --> calls _are_ allowed now:
      ```java
      f.scaleUp(objects);     ✅
      f.scaleUp(persons);     ✅ // (Person :> Employee)
      f.scaleUp(employees);   ✅
      f.scaleUp(developers);  ❌
      ```
- the parameter <!-- .element: class="fragment" --> `team` is 
  - **consuming** content
  - **at least** a list of employees or more general
---

### Contravariant
- A team doesn't only contain `Employee`s but also more general `Person`s, like temporary employees.
- So in <!-- .element: class="fragment" --> **this** case
  - we wanted to be able to **pass employees and persons**
  - we didn't care that we couldn't **read** them as `Employee` from the list

---

### Overview in code 
Invariant

![](../../img/traditional.png)

---

### Overview in code
Co- and contravariant

![](../../img/agile.png)

---

### Variance summary
- By default, a `List<T>` is **invariant**

---

### Variance summary
- Given `Developer <: Employee` 1️⃣ 
- Make <!-- .element: class="fragment" --> `List<Developer> <: List<Employee>` 2️⃣ with 
  - `...(List<? extends Employee> param)`
  - `param` acts as a **producer**
- Covariant <!-- .element: class="fragment" --> (_same_ direction): 
  - `<:` 1️⃣
  - `<:` 2️⃣

---

### Variance summary
- Given `Employee <: Person` 1️⃣
- Make <!-- .element: class="fragment" --> `List<Employee> :> List<Person>` 2️⃣ with
  - `...(List<? super Employee> param)`
  - `param` acts as a **consumer**
- Contravariant <!-- .element: class="fragment" --> (_opposite_ direction): 
  - `<:` 1️⃣ 
  - `:>` 2️⃣
---

### Variance summary
- **PECS**
  - **P**roducer **E**xtends (covariant)
  - **C**onsumer **S**uper (contravariant)

---

### Thanks!

See my article in JAVA MAGAZINE 2 – 2025 for NLJUG. 

https://nljug.org/java-magazine/java-magazine-2-2025/