import i18n from "i18next";
import { initReactI18next } from "react-i18next";

i18n.use(initReactI18next).init({
	resources: {
		en: {
			translations: {
				Home: "Home",
				Messages: "Messages",
				"Sign Up": "Sign Up",
				"Password mismatch": "Password mismatch",
				Username: "Username",
				"Display Name": "Display Name",
				Password: "Password",
				"Password Repeat": "Password Repeat",
				"I accept all the terms and conditions":
					"I accept all the terms and conditions",
				Login: "Login",
				Logout: "Logout"
			}
		},
		tr: {
			translations: {
				Home: "Ana Menü",
				Messages: "Mesajlar",
				"Sign Up": "Kayıt Ol",
				"Password mismatch": "Aynı şifreyi giriniz",
				Username: "Kullanıcı Adı",
				"Display Name": "Tercih Edilen İsim",
				Password: "Şifre",
				"Password Repeat": "Şifreyi Tekrarla",
				"I accept all the terms and conditions":
					"Tüm şartları ve koşulları kabul ediyorum",
				Login: "Giriş Yap",
				Logout: "Çıkış Yap"
			}
		}
	},
	fallbackLng: "en",
	ns: ["translations"],
	defaultNS: "translations",
	keySeparator: false,
	interpolation: {
		escapeValue: false,
		formatSeparator: ","
	},
	react: {
		wait: true
	}
});

export default i18n;
