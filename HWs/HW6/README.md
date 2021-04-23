# HW6 : Optimistic and Pessimistic Locking


A simple application that demonstrates the use of Optimistic and Pessimistic Locking.

Optimistic Locking does not lock out any resources. Instead, it resolves conflict when it finds one.  It uses @version to keep track of any possible inconsistent states of objects.  

Pessimistic Locking locks out resources.  Write lock and read lock are the two most common locks.  In read lock, any other transactions can read but not write.  On the other hand, in write lock, no other transactions can read nor write.   Spring implements pessimistic locking using @Lock at the repository query.

