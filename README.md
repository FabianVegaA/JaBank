# JaBank

## 1 Cuenta:

In this abstract class, I decided to make `Saldo` as an int and `numeroDeSaldo` as an Integer to make sure this did not change after it was created and both are protected for security and to that the class can allow have access to this. The functions all are protected by the same, without have count the functions get (getSaldo and getNúmeroDeCuenta.
In the case of _retirar_, this has the capacity of throws an exception when the cuenta doesn’t have enough Saldo (`if(this.Saldo - monto >= 0){...}else{throws new Exception}`). In addition to the functions that we had that make, I made `protected static int getLast_cuenta()` this return the last _cuenta_ made, that is save in `private static int last_cuenta;` and finally, we've `protected static void setLast_cuenta(Integer new_number)` that change the value of `last_cuenta`. All these are static types to be methods and attributes of the class and of this mode can have a constancy of when was the last _cuenta_.

### 1.1 Cuenta Vista:

This has his constructor and a function `public void transferir(int númeroDeCuenta, int monto)` (this is from the interfaces _Tarjeta_) that implement an Exception to call to `retirar` for the case where this throw an Exception and after use `abonar` from _Cuenta_.

### 1.2 Cuenta Corriente:

Samely that Cuenta Vista, this has a contructor and funcion transferir with the contrast of that have the next:

```java
try {
    ReadFile.getCuenta(númeroDeCuenta).abonar(monto);

    this.retirar(monto);

} catch (NullPointerException ex) {
    System.out.println("La cuenta :" + númeroDeCuenta + "no ha sido  encontrada");
}
```

For the case where `getCuenta(númeroDeCuenta)` no find the correspont _cuenta_.
This also has its own function `retirar` the wich can't throw an Exception because Cuenta Corriente can have negative `Saldo`.

### 1.3 Cuenta de Ahorro:

The constructor of this account does the use of _setLast_cuenta()_ and _getLast_cuenta()_, to it know which is the number of the account. Also has `private final float tasa;` that is initialized here.
For another way, this class has to:

```java
protected void retirar(int monto) throws Exception {
    if (this.días <= 0) {
        if (this.Saldo - monto > 0) {
            this.Saldo -= monto;
            this.días += 7;
        } else {
            throw new Exception();
        }
    }
    else{
        throw new Exception();
    }
}
```

With this, the function is able to throw Exceptions, in the case of that the _días_ or the _Saldo_ don't sufficient.

## 2 FormaDeAhorro:

This interface implements the corresponding abstracts functions.

```java
public abstract int getMonto();
public abstract void actualizar();
```

### 2.1 Fondo Mutuo:

Here is defined crecimiento, which is of type static and private.

```java
private static float crecimiento;
```

The functions get, set and _actulizar()_ are public to have information of the attributes of the object, the function _cobrar()_ is protected.

### 2.2 Depósito a Plazo:

This has a `private final float tasa;`,
by this when the cuenta is created, in the constructor tasa is initialize and after cannot change. Besides also have

```java
private int dias;
private int monto;
private Cuenta cuenta;
```

All are private to keep security.

By another way here we have the functions defined in _FormaDeAhorro_ and others.
In the constructor as
I mentioned, initialize _tasa_

```java
this.tasa = 1f + (FondoMutuo.getCrecimiento() - 1f) / 3;
```

Since Depósito a Plazo need that after of the correspondent days, this remove all and push in the account. This I do in _actualizar()_, here it if _días_ is great than zero then _monto_ updates and _días_ subtracted one, else the account call to _cobrar()_. Also the program have to _getMonto()_ (that return monto) and _cobrar()_ that subtract all and transfer to the account.

```java
protected void cobrar() {
    this.cuenta.abonar(this.monto);
    this.monto = 0;
}
```

## 3 ReadFile:

The function `transferir()` use the funcion `getCuenta()` for of this way get the account and do the operates that correspond as it sees to continuation:

```java
public static void transferir(Integer monto, Integer origen, Integer destino, String comando) {
getCuenta(origen).Saldo -= monto.intValue();
getCuenta(destino).Saldo += monto.intValue();
}
```
---

For run the program use:
``` Console
make
java /src/ReadFile .../file.jaBank
```
The Makefile have:
``` Console
make clear
```
