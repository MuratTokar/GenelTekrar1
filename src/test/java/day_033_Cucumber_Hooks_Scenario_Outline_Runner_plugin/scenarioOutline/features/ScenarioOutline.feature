Feature: Scenario Outline

  Scenario: scenario 1
    Given so scenario 1 setp 1
    Given so scenario 1 setp 2
    Then so scenario 1 setp 3

  Scenario: scenario 2
    Given so scenario 2 setp 1
    When so login with the following data
      | username | admin |
      | password | pass1 |
    Then so scenario 2 setp 1


  Scenario: scenario 3
    Given so my name is "Ahmet"
    Given so my age is 45
    Then so my country is "Ankara"

  #scenario outline de en alttta bir adet exaple bölümü olmali
  #example deki her bir satir icin senaryo tekrar edilir
  #example de ilk satir basliktir
  #bu verileri asagida kullanmak icin < > bu isaretler arasina alinir
  #bu senaryo 3 defa calisacak yani example sayisi kadar ve bu degiskenleri istedigim stapte kullanirim
  @sa
  Scenario Outline: scenario outline
    Given so my name is "<name>"
    When so my age is "<age>"
    Then so my country is "<city>"


    Examples:
      | name  | age | city     |
      | Ahmet | 50  | Ankara   |
      | Ali   | 34  | Istanbul |
      | Veli  | 45  | Adana    |

    @so2
  Scenario Outline: scenario outline 2
    Given so scenario <scenariono> setp <stepno1>
    When so login with the following data
      | username | <username> |
      | password | <password> |
    Then so scenario <scenariono> setp <stepno2>
    Examples:
      | scenariono | stepno1 | stepno2 | username | password |
      | 1          | 1       | 3       | admin    | pass1    |
      | 1          | 1       | 3       | admin    | pass1    |
      | 1          | 1       | 3       | admin    | pass1    |
