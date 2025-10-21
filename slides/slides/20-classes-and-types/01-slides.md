## Classes and types
<!-- .slide: class="is-fancy1" -->

---

> A _class_ is not a _type_

---

### Classes and types
Once you have declared a _class_, you can use it as a _type_ in places where a type is expected:
```java
public class Employee { /*...*/ }
//     class ^^^^^^^^ 

```
 
```java
class Finance {  
	void pay(Employee e) { /*...*/ }
	// type  ^^^^^^^^
}
```

---

### Classes and types
- Are _class_ and _type_ the same thing? 
  - Do they have a one-to-one relationship?
- Examples:
  - Class <!-- .element: class="fragment" --> `Employee` yields **one** usable type: 
    - `Employee`
  - Class <!-- .element: class="fragment" --> `List<T>` yields **many** usable types: 
    - `List<Employee>`, `List<Developer>`, `List<Manager>`, `List<String>`...

---

### Classes and types
> **One** class can yield **many** types.

One-to-**many** relationship. <!-- .element: class="fragment" -->

---

### Sub 🚇
Are _**sub**class_ and _**sub**type_ the same thing?

---

### Subtypes

In Java, you can create a subtype by creating a subclass, for example:
```java
class Developer extends Employee { /* ... */ }
```

---

### Subtypes

- Given this method:
    ```java
    class Finance {  
       void pay(Employee e) { /*...*/ }	
    }
    ```
- Are these calls allowed? <!-- .element: class="fragment" -->
	```java
    f.pay(anEmployee);
    f.pay(aDeveloper);
    ```
- Yes ✅! <!-- .element: class="fragment" --> 
- So: <!-- .element: class="fragment" -->
  - `Developer` is a subtype of `Employee`:
     ```console
     Developer <: Employee
     ```` 
---

### Subtypes
> B is a subtype of A if you can pass a B into a method that expects an A
 
It's <!-- .element: class="fragment" -->about **substitutability**.

![](../../img/liskov.jpg)
<!-- .element: class="fragment" -->

---
 
### Subtypes and generics
What about generic types?

Up next: variance!