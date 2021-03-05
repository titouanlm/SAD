# LAB 3

## Home tasks

**a)**

As in testFetch we load the employee, and the waiting time between this test and the first testCache is only 10 seconds, 
then the first testCache no longer needs to make a query because the employee is already loaded. 
This is due to the fact that the employee's cache has been increased to 20 seconds.


**b)** 

Here is the code I modified in User and Employee.

*User.class*

@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name = "emp_id", referencedColumnName = « id")
@JsonIgnore
@MapsId
private Employee emp;

*Employee.class*

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@OneToOne(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
private User user;

Now User table has the foreign key of Employee.




**c) **

The difference between cascade.REMOVE and orphanRemoval=true is, 

if I use cascade removal, it removes all children when parent is removed.

Else if I use orphan removal, it removes only corresponding child when I remove it from the relationships.




**d) **

When I removed lazy load from addresses and benefits, then it was eager load and, addresses and benefits has been load by default when I loaded employee.





**e) **

When I removed cascade = cascadeType.ALL and orphanRemoval = true from benefits and addresses, 2 things happened. First, when I run testCascadeRemove, Objects in addresses are not removed. 
Second, when I run testCascadePersist, benefits created does not persist in the database.





**f) **

Error obtain when I removed @Transactional from testCascadeRemove : No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call

The reason is that one Entity Manager can be used across several database transactions, so we inject an Entity Manager with @PersistenceContext to run in a single database transaction. But in this mode, we need to precise the method with @Transactional to use this Entity Manager inside.

**g)**

See *HibernateApplicationTests.java*
