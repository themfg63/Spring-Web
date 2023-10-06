package ytr.intern.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ytr.intern.springweb.HTTPRequest.Comment;
import ytr.intern.springweb.HTTPRequest.Post;

import java.net.URI;
import java.util.Arrays;
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

public class RestTemplateTest {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    RestTemplate restTemplate = new RestTemplate();

    //  1. Tüm postları getirin
    @Test
    void getPosts(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity,Post[].class);
        System.out.println(Arrays.stream(response.getBody()).toList());
    }

    //2. Id'si 2 olan postu getirin
    @Test
    void getSinglePost(){
        URI uri =UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts","2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post> response = restTemplate.exchange(requestEntity,Post.class);

        System.out.println(response.getBody());
    }

    //3. Yeni rastgele bir post ekleyin
    @Test
    void addPost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Post> request = RequestEntity
                .post(uri)
                .body(new Post(7L,null,"hebele","hübele"));

        ResponseEntity<Post> response = restTemplate.exchange(request,Post.class);
        System.out.println(response.getBody());
    }

    // 4. userId'si 2 olan postları getirin
    @Test
    void getPostById(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId","2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity,Post[].class);
        System.out.println(Arrays.stream(response.getBody()).toList());
    }

    //5. Id'si 5 olan commenti güncelleyin
    @Test
    void updateComment(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("comments","5")
                .build()
                .toUri();

        RequestEntity<Comment> requestEntity =  RequestEntity
                .put(uri)
                .body(new Comment(9L,5L,"HEBELE","hübele@gmail.com","hello"));
        ResponseEntity<Comment> response = restTemplate.exchange(requestEntity,Comment.class);
        System.out.println(response.getBody());
    }

    //6. Id'si 1 olan postu silin
    @Test
    void deletePost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts","2")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.delete(uri).build();
        ResponseEntity<Void> response = restTemplate.exchange(request,Void.class);
        System.out.println(response.getStatusCode());
    }
}
