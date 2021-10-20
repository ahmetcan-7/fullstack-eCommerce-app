import React, { useEffect } from "react";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import Product from "../components/Product";
import { fetchProducts } from "../redux/actions/productActions";
import "../styles/product.scss";

function ProductList() {
	const { products } = useSelector(state => state.product);
	const dispatch = useDispatch();

	useEffect(() => {
		dispatch(fetchProducts());
	}, []);

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
						stock={product.stock}
					/>
				))}
			</div>
		</div>

		/*
		<div className="album py-5 bg-light">
			<div className="container">
				<div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					{products.map(product => (
						<Product
							key={product.id}
							productName={product.productName}
							price={product.price}
							afterDiscountPrice={product.afterDiscountPrice}
							discountRate={product.discountRate}
						/>
					))}
				</div>
			</div>
		</div>
        </div>
        </div>
        </div>
        */
	);
}

export default ProductList;
