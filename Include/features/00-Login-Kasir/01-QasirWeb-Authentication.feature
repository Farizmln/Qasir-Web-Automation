Feature: Login Qasir.id
  Saya menuju halaman Qasir.id untuk login

 @Positive
 Scenario Outline: Berhasil login ke dalam Web Qasir.id
		Given Saya membuka browser dan menuju halaman Website Qasir.id
    When Saya menggunakan login via <via> dengan area id <areaid> melakukan input <userid>
    And Saya memasukkan nomor pin <pin>
    Then Saya menekan button login dan menuju ke halaman Qasir.id
    
    Examples: 
      | via           | areaid    | userid      | pin    | 
      | No. Handphone | Indonesia | 82213876823 | 123567 |