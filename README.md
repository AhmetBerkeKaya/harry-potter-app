# Harry Potter Character App

## Proje Açıklaması

Bu proje, **Harry Potter** evreninden karakterlerin bilgilerini görüntülemeyi amaçlayan bir Android uygulamasıdır. Kullanıcılar, uygulama üzerinden karakterlerin isimlerini, doğum tarihlerini, evlerini ve aktörlerini görebilirler. Proje, **Jetpack Compose** kullanılarak geliştirilmiş ve görsel olarak zenginleştirilmiş bir kullanıcı arayüzüne sahiptir. 

Uygulama, karakterlerin listelendiği bir ana menü ekranı ile başlar. Kullanıcılar, bu ekranda "Karakterleri Listele" butonuna tıklayarak tüm karakterlerin listelendiği ekrana geçebilir. Karakterlerin her biri, kendi detaylı sayfasına tıklanarak daha fazla bilgiye erişilebilir.

## Teknolojiler ve Kullanılan Yöntemler

- **Jetpack Compose**: Modern Android UI geliştirme için kullanılan bir araç. Kullanıcı dostu ve reaktif bir arayüz tasarımı sağlar.
- **Coil**: Görsel yükleme ve yönetimi için kullanılan hafif ve verimli bir kütüphane.
- **ViewModel**: Uygulamanın iş mantığını ve veri yönetimini kontrol altında tutmak için kullanılır. Ekran dönüşlerinde veri kaybını önler.
- **Retrofit**: REST API isteklerini yapmak için kullanılan güçlü bir HTTP istemcisidir. API'den karakter verilerinin doğru ve verimli şekilde çekilmesini sağlar.
- **Navigation Component**: Sayfalar arası geçişi yönetmek için kullanıldı.
- **Hata Yönetimi**: API bağlantı hataları gibi durumlarda kullanıcıya bilgi veren sistemler geliştirildi.
- **Gradle**: Proje bağımlılıklarını ve yapılandırmasını yöneten sistem.
  
## Kullanıcı Arayüzü

Uygulamanın ana menüsünde kullanıcıları karşılayan bir görsel ve yazı bulunmaktadır. Kullanıcılar, "Karakterleri Listele" butonuna tıklayarak karakterlerin listelendiği sayfaya geçerler. Her karakterin detay sayfasında ise, o karakterin ev, doğum tarihi, aktör bilgileri ve görseli görüntülenir.

### Ana Menü
![image](https://github.com/user-attachments/assets/9c269552-a114-4ee2-be93-fae0c7eee9dd)
![image](https://github.com/user-attachments/assets/3c1e4164-5733-4d20-877d-889d80b1831f)

Ana menü ekranında bir **buton** ve **Harry Potter temalı görsel** yer alır. Bu ekran, kullanıcıya uygulamanın neyle ilgili olduğunu kısa ve öz bir şekilde tanıtır.

### Karakter Detay Sayfası
![image](https://github.com/user-attachments/assets/8a762d22-b083-4e7f-afe6-92c7a9862c86)

Karakter detay sayfasında, seçilen karakterin ismi, ev bilgisi, doğum tarihi ve aktör bilgisi görüntülenir. Bu sayfa, görsel açıdan zengin ve kullanıcı dostudur.

## Projeyi Çalıştırmak İçin Gereksinimler

### Gereksinimler

- **Android Studio** (veya uyumlu bir IDE)
- **Java 11** veya üzeri
- **Android SDK** (Android Studio ile birlikte gelir)
- **Git** (veya bir sürüm kontrol aracı)

### Adımlar

1. **Repo'yu Klonla**:
   GitHub üzerinden projeyi bilgisayarınıza klonlayın:
   ```bash
   git clone https://github.com/kullanıcı_adınız/harrypotterapp.git
2. **Android Studio'yu Başlat:**

Android Studio'yu açın ve "Open Project" seçeneği ile projeyi açın.

3. **Bağımlılıkları Yükle**:  
   Proje açıldığında, Android Studio gerekli bağımlılıkları otomatik olarak yükleyecektir. Eğer yükleme yapılmazsa, terminal üzerinden aşağıdaki komutu çalıştırabilirsiniz:
   ```bash
   ./gradlew build

4. **Emülatörü Başlat:**

Android Studio üzerinde bir emülatör başlatın veya bağlı bir Android cihaz kullanın.

Projeyi Çalıştır:

Android Studio üzerindeki Run butonuna tıklayarak uygulamayı başlatın.

### Proje Yapısı
Proje şu şekilde yapılandırılmıştır:
- app/
  - src/
    - main/
      - java/
        - com/
          - ahmetberkekaya/
            - harrypotterapp/
              - ui/
                - screens/          # Kullanıcı arayüzü bileşenleri (MainMenuScreen, CharacterScreen, vb.)
                - navigation/        # Navigation grafiği (AppNavGraph)
              - data/
                - model/             # Karakter modeli
              - viewmodel/           # ViewModel (iş mantığı)
      - res/
        - drawable/              # Uygulama için görseller (icon'lar ve resimler)
      - values/
        - strings.xml            # Metinler ve diller
  - build.gradle
  - AndroidManifest.xml

## Video Kaydı(Örnek)


https://github.com/user-attachments/assets/b6be133d-8cb1-4b90-b6b7-665cbbb097de

