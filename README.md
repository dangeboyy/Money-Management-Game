# Money Management Game
In this project we built a game called “Money Management Game”. We filled the concepts of:

```
 Abstract Factory Design Pattern
 Chain of Responsibility Design Pattern
 Flyweight Design Pattern
 Java Swing (for GUI)
 File I/O
 MVC (Model-View-Controller) Pattern
 Three Layer Architecture
```
In this software there are 2 users that can be logged in. First one is “Factory Boss”. In the
game there are 3 Factories that produce products:

```
 Wooden Table Factory (Produce Wooden Table)
 Wooden Wardrobe Factory (Produce Wooden Wardrobe)
 Wooden Bookshelf Factory (Produce Wooden Bookshelf)
```
Factory Boss is responsible of his/her own factory’s “sale and buy wood” operations. When a
customer wants to buy a product, a request and a notification is sent to the related factory’s
boss. Then when the factory boss logged in he can do the following operations.

1. Approve a buy request (Selling product with profit)
    a. Approve Operation can do only the status of request is waiting. (A request type
       is waiting at the beginning).
    b. When approve operation is done products will be sent to the customer and
       factory’s money will increase with profit +100 $ for each product.
2. Deny a request
    a. When deny operation is done request owner’s money must be refund and a
       notification sent to the owner of request.
    b. Deny Operation can do only the status of request is waiting. (A request type is
       waiting at the beginning).
3. Buy wood (Unit price: 0.1$ )

Second user is Customer. Customers’ purpose in the game is making money and become rich.
Customer can do the following operations to achieve this goal:

1. Buy Products and sell them with profit (%10 for each product)
    a. If customer have enough money, order (request) will be sent to related factory
       boss. When approve is done unfortunately not always customer will have the
       all products that he/she ordered. Because during transportation %0-%20 of
       products can be broken. Therefore, customer may not profit from sales
       sometimes.
2. Play gamble (Roll dice)
    a. If customer have enough money to bet (min 1000$) can play gamble. Gamble
       is a guess game with %25 chance to win. Guessing the 4 faced dice result. If


```
wins then customer will have a %150 profit according to bet. If lose will lose
the all money that he/she bet.
```
3. Wish money from his/her family
    a. If customer need money can want money from family. Every customer has a
       sibling (40000$), parent (70000$) and grandparent (100000$).
    b. When customer wants a money from family this request is sent to customer’s
       sibling. According to the amount of requested money. Lander of the money
       will change. Because Whoever can afford the request, will give it. Those who
       cannot afford it, will send to the older ones. (No approve operation needed
       from family members).

Notes:

All the information is stored in JSON files. After each operation, files are updated.


