package ytr.intern.springweb.ValidationKurallari;
/* UYGULAMA
    -> Bir User class'ı oluşturun.
    -> İçerisinde şu alanlar bulunmalı: isim, soyisim, yaş, e-mail,TC kimlik no, doğum tarihi, ikametgah adresi ve kullanıcı adı olmalı.
    -> İsim, soyisim, kullanıcı adı,e-mail adresi boş olmamalı
    -> Yaşı, 12 ile 100 arasında olmalı
    -> E-mail adresi valid olmalı
    -> Doğum tarihi bugün veya daha öncesinde olmalı
    -> İkametgah adresi 250 karakterden kısa olmalı
    -> Kullanıcı adı "admin" olmamalı
 */


import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record User(
        @NotBlank(message = "name can't be empty") //tanımlanan değerin boş olamayacağını belirtir. Parantez içerisindeki mesaj da boş istek geldiğinde kullanıcıya gösterilecek hata mesajıdır
        String name,
        @NotBlank(message = "surname can't be empty")   //tanımlanan değerin boş olamayacağını belirtir.
        String surname,
        @Min(12)
        @Max(100)   //tanımlanan değerin min ve max değerleri arasında olması gerektiğini belirtir.
        Integer age,
        @NotBlank(message = "email can't be empty")   //tanımlanan değerin boş olamayacağını belirtir.
        @Email(message = "email must be valid")      //tanımlanan değerin email formatında olması gerektiğini belirtir.
        String email,
        String tcNo,
        @PastOrPresent      //tanımlanan tarihin bugün veya daha önceki bir tarih olması gerektiğini belirtir.
        LocalDate birthDate,
        @Size(max = 250)    //tanımlanan Stringin max 250 karakterden oluşabileceğini belirtir.
        String address,
        @NotBlank   //tanımlanan değerin boş olamayacağını belirtir.
        String username
) {

    //Kullanıcı adının admin olamayacığını belirten method
    @AssertTrue
    public boolean isUsernameValid(){
        return !username.equals("admin");
    }
}
