import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import Pagination from "../components/Pagination";
import Product from "../components/Product";
import { fetchProducts } from "../redux/actions/productActions";
import "../styles/product.scss";
import { useApiProgress } from "../shared/ApiProgress";

function ProductList() {
	const { products, pageNumber } = useSelector(state => state.product);

	const dispatch = useDispatch();

	useEffect(() => {
		dispatch(fetchProducts(pageNumber, 3, "id"));
	}, [pageNumber]);

	const pendingApiCall = useApiProgress('get', "/v1/product/getAllByPage?pageNo");

	return (
		<div className="container mydiv">
			<div className="row">
				{products.map(product => (
					<Product
						key={product.id}
						productName={product.productName}
						price={product.price}
						afterDiscountPrice={product.afterDiscountPrice}
						discountRate={product.discountRate}
						category={product.category.categoryName}
						brand={product.brand.brandName}
						stock={product.stock}
					/>
				))}
			</div>
			<Pagination pendingApiCall={pendingApiCall} />
		</div>
	);
}

export default ProductList;
