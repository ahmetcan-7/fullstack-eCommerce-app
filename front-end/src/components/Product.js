import React from "react";
import AddToCartButton from "./AddToCartButton";

function Product({
	productName,
	price,
	afterDiscountPrice,
	discountRate,
	category,
	stock,
	brand
}) {
	return (
		<div className="col-md-4">
			<div className="bbb_deals">
				<div className="ribbon ribbon-top-right">
					<span>
						<small className="cross">% </small>
						{discountRate}
					</span>
				</div>
				<div className="bbb_deals_title">{brand}</div>
				<div className="bbb_deals_slider_container">
					<div className=" bbb_deals_item">
						<div className="bbb_deals_image">
							<img src="https://i.imgur.com/9UYzfny.png" alt="" />
						</div>
						<div className="bbb_deals_content">
							<div className="bbb_deals_info_line d-flex flex-row justify-content-start">
								<div className="bbb_deals_item_category w-100">
									<a href="#!">{category}</a>
								</div>
								<div className="bbb_deals_item_price_a ml-auto">
									<strike>{price} TL</strike>
								</div>
							</div>
							<div className="bbb_deals_info_line d-flex flex-row justify-content-start">
								<div className="bbb_deals_item_name w-100">{productName}</div>
								<div className="bbb_deals_item_price ml-auto">
									{afterDiscountPrice} TL
								</div>
							</div>
							<div className="available">
								<div className="available_line d-flex flex-row justify-content-start align-items-center">
									<div className="available_title w-100">
										Available: <span>{stock}</span>
									</div>
									<AddToCartButton />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
}

export default Product;
