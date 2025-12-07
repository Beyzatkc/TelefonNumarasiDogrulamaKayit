# TelefonNumarasiDogrulamaKayit

TelefonNumarasiDogrulamaKayit, bir telefon numarasını doğrulama ve kayıt etme işlemlerini kolaylaştıran bir Java tabanlı web uygulamasıdır. Kullanıcıdan alınan telefon numarası üzerinde doğrulama yapılır ve başarılı doğrulama sonrası sisteme kayıt edilir. Modern web teknolojileri ile oluşturulmuş bu proje, hem görsel açıdan zengin hem de veri bütünlüğü açısından güvenilirdir.

## Özellikler

- **Telefon Numarası Doğrulama**: Kullanıcıdan alınan telefon numarasının format ve geçerlilik kontrolleri yapılır.
- **Kullanıcı Arayüzü**: HTML, CSS ve JavaScript ile hazırlanmış kullanıcı dostu arayüz.
- **Veri Kayıt**: Doğrulanmış telefon numaraları veri tabanına kaydedilir.
- **Docker Desteği**: Proje, kolay kurulum ve taşınabilirlik için Docker ile container halinde çalıştırılabilir.

## Kullanılan Teknolojiler

- **Java** — Backend (Spring, Servlet vb. ile yazılmış olabilir)
- **HTML, CSS, JavaScript** — Frontend
- **Dockerfile** — Uygulamanın hızlıca container ortamında ayağa kaldırılması için
- **SpringBoot** -Mysqli kolay kullanmak için

## Kurulum

## 1. Kaynak Kodun Edinilmesi

Git ile projenin son sürümünü bilgisayarınıza klonlayınız:
```bash
git clone https://github.com/Beyzatkc/TelefonNumarasiDogrulamaKayit.git
cd TelefonNumarasiDogrulamaKayit
```

## 2. Projeyi Çalıştırmak (Docker ile)

Docker'ın yüklü olduğuna emin olun.

```bash
docker compose up --build -d
```
Uygulama şimdi `http://localhost:8080` adresinde çalışıyor olacaktır.

## 3. Web Arayüzünü Kullanmak

Tarayıcıdan aşağıdaki adrese giderek arayüzü kullanabilirsiniz:
```
http://localhost:8080
```

## 1. Telefon Numarası Doğrulama
**Açıklama:** Telefon numarasını matematiksel kurallara göre doğrular. Veritabanına kayıt yapmaz.  
**HTTP Method:** `POST`  
**URL:** `http://localhost:8080/api/phone/validate`  

**Giriş Parametreleri (JSON):**  
```json
{
  "number": "054153"
}

**Örnek Yanıt:** 
{
  "number": "054153",
  "rules": {
    "hasNonZeroDigit": true,
    "sumFirstEqualsLast": true,
    "sumOddEqualsEven": true
  },
  "isValid": true
}
```
## 2. Kullanıcı Kaydı (Doğrulama + Veritabanı Kaydı)

**Açıklama:** Telefon numarasını doğrular; geçerliyse kullanıcıyı MySQL veritabanına kaydeder.  
**HTTP Method:** `POST`  
**URL:** `http://localhost:8080/api/registration`  

**Giriş Parametreleri (JSON):**  
```json
{
  "name": "Ali Veli",
  "email": "ali@example.com",
  "phoneNumber": "054153"
}
```

**Örnek Başarılı Yanıt (201 Created):**

{
  "status": "accepted",
  "message": "Telefon numarası geçerli, kayıt başarıyla oluşturuldu.",
  "userResponseDTO": {
    "id": 1,
    "name": "Ali Veli",
    "email": "ali@example.com",
    "phone": "054153",
    "date": "2025-12-07T17:20:59.556784982"
  },
  "valid": true
}

## 3. Geçerli Telefon Numarası Sayısı

**Açıklama:** Kurallara uyan toplam farklı telefon numarası sayısını hesaplayıp döner.  
**HTTP Method:** `GET`  
**URL:** `http://localhost:8080/api/phone/count`  

**Giriş Parametresi:** Yok  

**Örnek Yanıt:**  
```json
1

```
## 4. Son Üç Kullanıcıyı Getir
**Açıklama:** Sisteme son kayıt olan 3 kullanıcıyı sıralı şekilde döndürür.
**HTTP Method:** GET
**URL:** http://localhost:8080/api/last-three

**Giriş Parametresi:** Yok

**Örnek Yanıt:**

[
  {
    "id": 1,
    "name": "Ali Veli",
    "email": "ali@example.com",
    "phone": "054153",
    "date": "2025-12-07T17:20:59.556785"
  }
]



**İletişim:** [GitHub üzerinden mesaj atabilirsiniz](https://github.com/Beyzatkc)

