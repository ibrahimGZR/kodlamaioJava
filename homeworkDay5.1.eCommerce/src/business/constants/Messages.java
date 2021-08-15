package business.constants;

public class Messages {
	public static void userRegister(String userName) {
		System.out.println("Kayıt başarili hoşgeldin " + userName);
	}

	public static void userLogin(String userName) {
		System.out.println("Giriş Başarılı hoşgeldin " + userName);
	}

	public static void registerWithGoogle(String userName) {
		System.out.println("Google ile Kayıt olundu hoşgeldin " + userName);
	}

	public static void loginWithGoogle(String userName) {
		System.out.println("Google ile Giriş yapıldı hoşgeldin " + userName);
	}

	public static void userNotFound() {
		System.out.println("Kullanıcı bulunamadı");
	}

	public static void wrongPassword() {
		System.out.println("Yanlış şifre");
	}

	public static void userAlreadyExists() {
		System.out.println("Kullanıcı zaten mevcut");
	}

	public static void checkPassword() {
		System.out.println("Şifre en az 6 karekterden oluşmalı");
	}

	public static void checkName() {
		System.out.println("Ad en az 2 karekterden oluşmalı");
	}

	public static void checkLastName() {
		System.out.println("Soyad en az 2 karekterden oluşmalı");
	}

	public static void checkEmailRegex() {
		System.out.println("Geçersiz email");
	}

	public static void sendEmail(String email) {
		System.out.println(email + " mailinize kod gönderildi");
	}

	public static void sendEmailCode(String uuid) {
		System.out.println("Email Kodunuz: " + uuid);
	}

	public static void verificationFailed() {
		System.out.println("Doğrulama başarısız kayıt olunamadı");
	}

	public static void clickOnTheLink() {
		System.out.println("Linke tıklamak için Y tuşuna basın: ");
	}
}
