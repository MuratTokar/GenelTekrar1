Feature:Bu feature ile ilgili detayli aciklamalar yazilir

  Scenario: Matematiksel islemler
    Given baslangic sayisi 2
    When bu sayiya 3 eklendiginde
    Then sonuc 5 olmali
    And sonuc uygun
    And  netice"olumlu" olmali
    
    Scenario: scenario2
      Given baslangic sayisi 1
      When bu sayiya 2 eklendiginde
      And bu sayiya 3 eklendiginde
      And bu sayiya 5 eklendiginde
      Then sonuc 11 olmali
