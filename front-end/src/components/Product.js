import React from "react";

function Product({
	productName,
	price,
	afterDiscountPrice,
	discountRate,
	category,
	stock
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
				<div className="bbb_deals_title">Today's Combo Offer</div>
				<div className="bbb_deals_slider_container">
					<div className=" bbb_deals_item">
						<div className="bbb_deals_image">
							<img src="https://i.imgur.com/9UYzfny.png" alt="" />
						</div>
						<div className="bbb_deals_content">
							<div className="bbb_deals_info_line d-flex flex-row justify-content-start">
								<div className="bbb_deals_item_category">
									<a href="#!">{category}</a>
								</div>
								<div className="bbb_deals_item_price_a ml-auto">
									<strike>{price}</strike>
								</div>
							</div>
							<div className="bbb_deals_info_line d-flex flex-row justify-content-start">
								<div className="bbb_deals_item_name">{productName}</div>
								<div className="bbb_deals_item_price ml-auto">
									{afterDiscountPrice}
								</div>
							</div>
							<div className="available">
								<div className="available_line d-flex flex-row justify-content-start">
									<div className="available_title">
										Available: <span>{stock}</span>
									</div>
									<div className="sold_stars ml-auto">
										{" "}
										<i className="fa fa-star"></i>{" "}
										<i className="fa fa-star"></i>{" "}
										<i className="fa fa-star"></i>{" "}
										<i className="fa fa-star"></i>{" "}
										<i className="fa fa-star"></i>{" "}
									</div>
								</div>
								<div className="available_bar">
									<span style={{ width: "17%" }}></span>
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
