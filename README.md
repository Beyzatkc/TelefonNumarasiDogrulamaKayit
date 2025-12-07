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

### 1. Kaynak Kodun Edinilmesi

Git ile projenin son sürümünü bilgisayarınıza klonlayınız:
```bash
git clone https://github.com/Beyzatkc/TelefonNumarasiDogrulamaKayit.git
cd TelefonNumarasiDogrulamaKayit
```

### 2. Projeyi Çalıştırmak (Docker ile)

Docker'ın yüklü olduğuna emin olun.

```bash
docker compose --build -d
```
Uygulama şimdi `http://localhost:8080` adresinde çalışıyor olacaktır.
```

### 4. Web Arayüzünü Kullanmak

Tarayıcıdan aşağıdaki adrese giderek arayüzü kullanabilirsiniz:
```
http://localhost:8080
```

**İletişim:** [GitHub üzerinden mesaj atabilirsiniz](https://github.com/Beyzatkc)
