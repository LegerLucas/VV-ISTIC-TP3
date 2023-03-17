# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. Dans ce cas, l'expression `3 * .4` produit le résultat `1.2000000000000002`, qui est très proche de `1.2` mais pas exactement égal à celui-ci. Par conséquent, l'affirmation échoue. Pour vérifier l'égalité des nombres à virgule flottante, il est  généralement préférable d'utiliser une valeur d'écart, qui est un petit  nombre représentant la différence maximale autorisée entre les valeurs  attendues et réelles.

2. La différence entre les deux méthodes est que `assertEquals` vérifie si les deux objets ont la même valeur, tandis que `assertSame` vérifie si les deux objets font référence au même objet dans la mémoire.

   ```java
   String s1 = "hello";
   String s2 = "hello";
   assertEquals(s1, s2);
   assertSame(s1, s2)
   ```

   Voici un test ou assertEquals et assertSame ont le même résultat

   

   ```java
   String s1 = "hello";
   String s2 = new String("hello");
   assertEquals(s1, s2);
   assertNotSame(s1, s2);
   ```

​		Voici un test ou assertEquals et assertSame n'ont pas le même résultat

3.

    1. Vérification de la validité des arguments d'une méthode

Lors de la création d'une méthode, il est parfois nécessaire de vérifier la validité des arguments passés à cette méthode. Si un argument est invalide, la méthode ne peut pas être exécutée correctement. Dans ce cas, il est courant d'utiliser `fail` pour signaler l'erreur et arrêter l'exécution de la méthode. Par exemple :

```
java
public void setAge(int age) {
    if (age < 0) {
        fail("L'âge ne peut pas être négatif");
    }
    this.age = age;
}
```

Dans cet exemple, la méthode `setAge` vérifie si l'âge est un nombre positif. Si ce n'est pas le cas, la méthode échoue avec un message d'erreur approprié.

    2. Gestion d'erreurs inattendues

Parfois, une méthode peut rencontrer une erreur inattendue qui ne peut pas être gérée correctement. Dans ce cas, il est courant d'utiliser `fail` pour signaler l'erreur et arrêter l'exécution de la méthode. Par exemple :

```
java
public int divide(int num1, int num2) {
    if (num2 == 0) {
        fail("Division par zéro");
    }
    return num1 / num2;
}
```

Dans cet exemple, la méthode `divide` vérifie si le deuxième nombre est différent de zéro. Si ce n'est pas le cas, la méthode échoue avec un message d'erreur approprié.

4.

    1. Plus grande expressivité

La méthode `assertThrows` est plus expressive que les annotations `@Test`. Elle permet de spécifier clairement quelle exception est attendue, ce qui rend le code plus lisible et facilite la compréhension de l'intention du test.

    2. Plus grande flexibilité

La méthode `assertThrows` permet de tester différentes exceptions dans un même test, contrairement à l'utilisation des annotations `@Test` où une seule exception était testée à la fois. Cela permet de réduire le nombre de tests nécessaires et d'augmenter l'efficacité des tests.

    3. Contrôle plus précis de l'exécution du test

La méthode `assertThrows` permet de contrôler plus précisément l'exécution du test en vérifiant si l'exception a été levée au bon endroit du code. Par exemple, il est possible de vérifier que l'exception a été levée avant l'exécution d'une partie de code spécifique.

    4. Meilleure séparation des préoccupations

En utilisant la méthode `assertThrows`, la vérification de l'exception est séparée de l'exécution du code qui lève l'exception. Cela permet de mieux séparer les préoccupations et d'éviter les dépendances inutiles entre les différentes parties du code.