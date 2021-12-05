Feature: Choose Outlet and Change Profile
  Saya menuju halaman Qasir.id untuk memilih outlet dan merubah profil

 @Positive
 Scenario Outline: Berhasil Memilih Outlet dan Merubah Profil User
    Given Saya berada pada pemilihan outlet sebelum masuk Halaman utama dan memilih outlet <outlet>
    When Saya berada di Halaman utama dan memastikan pemilihan dropdown outlet <outlet>
    And Saya melakukan klik gambar profil dan memilih sub-menu Profil Pengguna 
    And Saya merubah foto profil dengan gambar <gambar> dan menerapkan foto
    And Saya merubah Nama Depan dengan <nama> dan Nama Belakang dengan <namablkg> dan menyimpan perubahan tersebut
    And Saya melakukan pengecekan perubahan dari nama depan <nama> dan Nama Belakang <namablkg>
    Then Kemudian saya logout dari web Qasir.id

    Examples: 
      | outlet        | gambar | nama     | namablkg | 
      | Cabang Condet | kucing | Muhammad | Fariz    |