package ytr.intern.springweb.HTTPRequest;
/* UYGULAMA
    -> İçerisinde userId,id,title ve body bulunduran Post class'ı ve içerisinde postId,id,name,email ve body bulunduran
    Comment class'ını oluşturun.
    -> Aşağıdaki requestleri RestTemplate, UriComponentsBuilder ve RequestEntity kullanarak jsonplaceholder'a(API) yollayın
    ve sonuçlarını konsola basın.

    1. Tüm postları getirin,
    2. Id'si 2 olan postu getirin,
    3. Yeni rastgele bir post ekleyin,
    4. userId'si 2 olan postları getirin
    5. Id'si 5 olan commenti güncelleyin
    6. Id'si 1 olan postu silin

 */
public record Post(
        Long userId,
        Long id,
        String title,
        String body
) {
}
