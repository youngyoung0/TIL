package sample.cafekiosk.spring.api.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.cafekiosk.spring.api.controller.product.dto.request.ProductCreateRequest;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * readOnly = true : 읽기전용
 * CRUD에서 CUD 동작 X / only Read
 * JPA : CUD 스냅샷 저장, 변경감지 X (성능 향상)
 *
 * CQRS : Command / Read
 *
 */
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 동시성 이슈
    public List<ProductResponse> getSellingProducts(){
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(product -> ProductResponse.of(product))
                .collect(Collectors.toList());
    }

    public ProductResponse createrProduct(ProductCreateRequest request) {
        // nextProductNumber
        String nextProductNumber = creatNextProductNumber();

        Product product = request.toEntity(nextProductNumber);
        Product savedProduct = productRepository.save(product);


        return ProductResponse.of(savedProduct);
    }

    private String creatNextProductNumber(){
        String latestProductNumber = productRepository.findLatestProductNumber();
        if(latestProductNumber == null){
            return "001";
        }

        int latestProductNumberInt = Integer.valueOf(latestProductNumber);
        int nextProductNumberInt = latestProductNumberInt + 1;

        // 9 -> 009 10 -> 010
        return String.format("%03d", nextProductNumberInt);
    }
}
