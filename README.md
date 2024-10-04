## Exercício em Java para treinar tratamento de exceções
### Programa principal:
```java
package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.LimitException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer accNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String accHolder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			Account acc = new Account(accNumber, accHolder, initialBalance, withdrawLimit);
			sc.nextLine();
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			acc.withdraw(withdraw);
			System.out.printf("New balance: %.2f", acc.getBalance());
		} catch (LimitException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Error!");
		}
		
		sc.close();	
	}

}
```
Saída esperada:
![image](https://github.com/user-attachments/assets/31e1b123-d526-472e-9404-7430e813200c)

