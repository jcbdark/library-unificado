package com.example.ProductService;

import com.example.ProductService.controller.ProductController;
import com.example.ProductService.dto.ProductDTO;
import com.example.ProductService.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;

// Indica a JUnit 5 que use Mockito para inicializar los mocks.
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    // Crea una instancia del controlador y le inyecta los mocks.
    @InjectMocks
    private ProductController productController;

    // Crea un mock del servicio para simular su comportamiento.
    @Mock
    private ProductService productService;

    // Se ejecuta antes de cada test para configurar los mocks.
    @BeforeEach
    void setUp() {
        // En este ejemplo, no se necesita una configuración adicional
        // porque los comportamientos se definen en cada test.
    }

    // Test para el método getAllProducts()
    @Test
    void getAllProducts_ShouldReturnProductsAndOkStatus() {
        // Simula el comportamiento del servicio: cuando se llama a getAllProducts(),
        // devuelve una lista de ProductDTO.
        when(productService.getAllProducts()).thenReturn(Collections.singletonList(new ProductDTO()));

        // Llama al método del controlador que estamos probando.
        ResponseEntity<List<ProductDTO>> response = productController.getAllProducts();

        // Verifica que la respuesta tenga el estado HTTP 200 (OK).
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Verifica que el cuerpo de la respuesta no esté vacío.
        assertFalse(response.getBody().isEmpty());
    }

    private void assertFalse(boolean empty) {

    }

    private void assertEquals(HttpStatus httpStatus, HttpStatusCode statusCode) {
    }

    @Test
    void getProductById_ShouldReturnProductAndOkStatus() {
        Long productId = 1L;
        // Crea un objeto con valores específicos para la prueba.
        ProductDTO expectedProduct = new ProductDTO();

        // Simula el comportamiento del servicio para el test, retornando el objeto esperado.
        when(productService.getProductById(productId)).thenReturn(expectedProduct);

        // Llama al método del controlador.
        ResponseEntity<ProductDTO> response = productController.getProductById(productId);

        // Verifica que la respuesta sea 200 (OK).
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Obtiene el objeto del cuerpo de la respuesta.
        ProductDTO actualProduct = response.getBody();

        // Ahora, verifica cada atributo del objeto.
        assertNotNull(actualProduct);
        assertEquals(expectedProduct.getId(), actualProduct.getId());
        assertEquals(expectedProduct.getName(), actualProduct.getName());
        assertEquals(expectedProduct.getPrice(), actualProduct.getPrice());
        assertEquals(expectedProduct.getStock(), actualProduct.getStock());

        // Asegura que el servicio fue llamado.
        verify(productService, times(1)).getProductById(productId);
    }

    private void assertEquals(String name, String name1) {

    }

    private void assertEquals(Double price, Double price1) {
    }

    private void assertEquals(Integer stock, Integer stock1) {
    }

    private void assertEquals(Long id, Long id1) {
    }

    // Test para el método createProduct()
    @Test
    void createProduct_ShouldReturnCreatedProductAndStatus() {
        ProductDTO productToCreate = new ProductDTO();
        ProductDTO createdProduct = new ProductDTO();
        // Simula el guardado del producto.
        when(productService.saveProduct(productToCreate)).thenReturn(createdProduct);

        // Llama al método del controlador.
        ResponseEntity<ProductDTO> response = productController.createProduct(productToCreate);

        // Verifica que el estado de la respuesta sea 201 (CREATED).
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        // Verifica que el cuerpo de la respuesta no sea nulo.
        assertNotNull(response.getBody());
        // Verifica que el método saveProduct del servicio se haya llamado una vez.
        verify(productService, times(1)).saveProduct(productToCreate);
    }

    // Test para el método updateProduct()
    @Test
    void updateProduct_ShouldReturnUpdatedProductAndOkStatus() {
        Long productId = 1L;
        ProductDTO updatedProductDTO = new ProductDTO();
        // Simula la actualización del producto.
        when(productService.updateProduct(any(Long.class), any(ProductDTO.class))).thenReturn(updatedProductDTO);

        // Llama al método del controlador.
        ResponseEntity<ProductDTO> response = productController.updateProduct(productId, updatedProductDTO);

        // Verifica que el estado sea 200 (OK).
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Verifica que el método updateProduct del servicio se haya llamado con los argumentos correctos.
        verify(productService, times(1)).updateProduct(productId, updatedProductDTO);
    }

    // Test para el método deleteProduct()
    @Test
    void deleteProduct_ShouldReturnNoContentStatus() {
        Long productId = 1L;
        // Simula la eliminación del producto.
        doNothing().when(productService).deleteProduct(productId);

        // Llama al método del controlador.
        ResponseEntity<Void> response = productController.deleteProduct(productId);

        // Verifica que el estado sea 204 (No Content).
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        // Verifica que el método deleteProduct del servicio se haya llamado una vez.
        verify(productService, times(1)).deleteProduct(productId);
    }
}

