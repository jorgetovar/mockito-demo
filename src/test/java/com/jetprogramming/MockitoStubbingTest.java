package com.jetprogramming;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockitoStubbingTest {
	private ProductService productService;
	private ProductDao productDao;
	private Product product;

	@Before
	public void setupMock() {
		productService = new ProductService();
		product = mock(Product.class);
		productDao = mock(ProductDao.class);
		productService.setProductDao(productDao);
	}

	@Test
	public void testBuy() throws InsufficientProductsException {
		/* Stubbing getAvailableProducts(product) to return 30 */
		when(productDao.getAvailableProducts(product)).thenReturn(30);
		assertEquals(30, productDao.getAvailableProducts(product));
		// We verified that the orderProduct() method of the ProductDao
		// mock get’s invoked with the expected set of parameters (that we
		// passed to buy()).
		// productService.buy(product, 5);
		// verify(productDao).orderProduct(product, 5);
	}
}