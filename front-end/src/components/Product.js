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
									<a href="#">{category}</a>
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
		/*
		<div className="col">
			<div className="card shadow-sm">
				<svg
					className="bd-placeholder-img card-img-top"
					width="100%"
					height="225"
					xmlns="http://www.w3.org/2000/svg"
					role="img"
					aria-label="Placeholder: Thumbnail"
					preserveAspectRatio="xMidYMid slice"
					focusable="false"
				>
					<title>Placeholder</title>
					<rect width="100%" height="100%" fill="#55595c"></rect>
					<text x="50%" y="50%" fill="#eceeef" dy=".3em">
						{productName}
					</text>
				</svg>

				<div className="card-body">
					<p className="card-text">{productName}</p>
					<div className="d-flex justify-content-between align-items-center">
						<div className="btn-group">
							<button
								type="button"
								className="btn btn-sm btn-outline-secondary"
							>
								{price}
							</button>
							<button
								type="button"
								className="btn btn-sm btn-outline-secondary"
							>
								{afterDiscountPrice}
							</button>
						</div>
						<small className="text-muted">9 mins</small>
					</div>
				</div>
			</div>
		</div>
        */
	);
}

export default Product;
