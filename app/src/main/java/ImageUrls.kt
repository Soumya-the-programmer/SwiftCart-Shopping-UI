package com.example.shoppingui

sealed class ImageUrls {
    companion object {
        val urls = mapOf(
            "https://latin-quarters.com/cdn/shop/files/LQB_WHITE_1.jpg?v=1705384590" to listOf(
                "Casual V-neck",
                1189,
                "Chic and versatile V-neck top designed to elevate casual fashion with a touch of sophistication and effortless elegance."
            ),
            "https://assets.ajio.com/medias/sys_master/root/20240314/fliM/65f2a8fa05ac7d77bbb22d87/-473Wx593H-465889481-black-MODEL.jpg" to listOf(
                "Neck Gown Dress",
                582,
                "Elegant evening gown with a graceful neckline, blending charm and refinement for unforgettable moments of elegance."
            ),
            "https://m.media-amazon.com/images/I/51yRIDJvGCL._AC_UY1100_.jpg" to listOf(
                "One Piece",
                672,
                "Stylish and versatile one-piece outfit, perfectly tailored for casual elegance and effortless all-day comfort."
            ),
            "https://www.kreeva.com/cdn/shop/collections/lehenga-choli-kreeva-lifestyle.png?v=1721159766" to listOf(
                "Lehenga",
                799,
                "Vibrant and intricately designed lehenga, ideal for traditional celebrations with a touch of festive grace."
            ),
            "https://5.imimg.com/data5/SELLER/Default/2022/9/OI/TA/GV/160224028/women-t-shirt.jpg" to listOf(
                "Casual T-shirt",
                3942,
                "Classic casual T-shirt with a relaxed fit, perfect for comfortable, everyday wear with modern simplicity."
            ),
            "https://5.imimg.com/data5/SELLER/Default/2023/9/343548496/CP/GI/WM/155257574/designer-crop-top-lehenga-choli-500x500.jpg" to listOf(
                "Crop Top",
                3450,
                "Trendy crop top with chic design, adding a stylish twist to contemporary ethnic fashion."
            ),
            "https://www.jiomart.com/images/product/original/rvtqbkjf4k/harrica-fashion-women-s-gown-dress-latest-georgette-long-ethnic-anarkali-gown-for-women-and-girls-product-images-rvtqbkjf4k-3-202205280132.jpg?im=Resize=(500,630)" to listOf(
                "Long Ethnic Gown",
                2500,
                "Graceful georgette gown, embracing elegance and cultural beauty in a flowing traditional style."
            ),
            "https://assets.ajio.com/medias/sys_master/root/20240612/PXAi/666a1b7505ac7d77bb18fddb/-1117Wx1400H-463060378-green-MODEL3.jpg" to listOf(
                "Anarkali",
                2999,
                "Luxurious Anarkali crafted with intricate details, ideal for grand festivities and traditional elegance."
            ),
            "https://cdn.sareesaga.com/image/cache/data18/amazing-plain-cotton-designer-kurti-214168-1000x1375.jpg" to listOf(
                "Cotton Kurti",
                1499,
                "Soft, breathable cotton kurti offering comfort and timeless style for any casual or semi-formal occasion."
            ),
            "https://www.soosi.co.in/cdn/shop/products/WhatsAppImage2020-05-31at10.02.34_2048x.jpg?v=1590900578" to listOf(
                "Kurti & Palazzo",
                2999,
                "Chic Kurti and Palazzo set, seamlessly combining style and comfort for effortless elegance."
            ),
            "https://static.wixstatic.com/media/4594f8_c69ecd10fa4a480fb87719cefa5aeb58~mv2.jpg/v1/fill/w_480,h_640,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/4594f8_c69ecd10fa4a480fb87719cefa5aeb58~mv2.jpg" to listOf(
                "Summer Green",
                2899,
                "Vibrant green summer dress, capturing the essence of sunny days with a splash of color and chic style."
            ),
            "https://assets2.andaazfashion.com/media/catalog/product/cache/1/image/800x1200/a12781a7f2ccb3d663f7fd01e1bd2e4e/e/m/embroidered-silk-teal-green-saree-sarv145314-1.jpg" to listOf(
                "Silk Teal Green",
                2999,
                "Exquisite teal silk saree with delicate details, perfect for adding sophistication to any formal event."
            ),
            "https://rukminim2.flixcart.com/image/850/1000/xif0q/kids-top/a/r/o/11-12-years-ox-top-6-oriex-original-imagzkg3c6xvr4ny.jpeg?q=90&crop=false" to listOf(
                "Cotton Strap Top",
                1599,
                "Lightweight and stylish strap top, combining comfort and casual elegance for summer fashion."
            ),
            "https://www.jiomart.com/images/product/original/rvmqh8ovuu/diaz-stylish-crop-tops-for-women-half-sleeves-crop-top-cotton-crop-t-shirts-for-women-girls-women-crop-top-t-shirt-product-images-rvmqh8ovuu-4-202303231315.jpg?im=Resize=(500,630)" to listOf(
                "Half Crop Top",
                1499,
                "Trendy half crop top with a minimalist design, ideal for everyday comfort and style."
            ),
            "https://img.tatacliq.com/images/i11/437Wx649H/MP000000018092482_437Wx649H_202306240103331.jpeg" to listOf(
                "Jump Suit Purple",
                1899,
                "Modern and chic purple jumpsuit, perfect for making a bold fashion statement effortlessly."
            ),
            "https://athenalifestyle.com/cdn/shop/products/15-09-202200425_1.jpg?v=1667983292" to listOf(
                "3 Piece",
                2999,
                "Sophisticated 3-piece ensemble, merging classic elegance with contemporary style for versatile fashion."
            ),
            "https://assets.ajio.com/medias/sys_master/root/20230629/PDxv/649cbac2a9b42d15c91872de/-473Wx593H-465978829-pink-MODEL.jpg" to listOf(
                "2 Piece",
                2995,
                "Effortlessly stylish 2-piece outfit, offering modern flair with a comfortable, relaxed fit."
            ),
            "https://www.lavanyathelabel.com/cdn/shop/products/lbl101ks544dsc_2221.jpg?v=1672242281" to listOf(
                "Green Anarkali",
                3499,
                "Elegant green Anarkali, embodying sophisticated tradition with intricate design and timeless charm."
            ),
            "https://img.tatacliq.com/images/i16//437Wx649H/MP000000021635720_437Wx649H_202403211908471.jpeg" to listOf(
                "Frock",
                999,
                "Adorable frock design, blending comfort with sweet charm for any casual occasion."
            ),
            "https://assets.ajio.com/medias/sys_master/root/20240131/SSO7/65ba81578cdf1e0df5dca3b5/-473Wx593H-467027148-pink-MODEL.jpg" to listOf(
                "Embellished Gown",
                1399,
                "Gorgeous embellished gown, adorned with beautiful details for a look of grace and elegance."
            ),
            "https://assets.myntassets.com/dpr_1.5,q_60,w_400,c_limit,fl_progressive/assets/images/2024/SEPTEMBER/11/kZ4odYmW_e99501711ca5484fb4486ba074a25682.jpg" to listOf(
                "Formal Blazor Dress",
                1899,
                "Sleek formal blazer dress, radiating a sophisticated blend of business and style."
            ),
            "https://nolabels.in/cdn/shop/files/3_0ace6845-aab3-48a8-b7e2-cd5888e5f1ff.jpg?v=1721026559&width=1080" to listOf(
                "Elegant Dress",
                2299,
                "Classic women’s dress, combining effortless elegance and contemporary style for an all-occasion outfit."
            ),
            "https://assets.myntassets.com/dpr_1.5,q_60,w_400,c_limit,fl_progressive/assets/images/28997522/2024/4/17/f816f9ed-57d0-4c31-9ab6-d993e35a089e1713336009483AthenaImmutableScubaFormalDress1.jpg" to listOf(
                "Belted Dress",
                2999,
                "Modern belted dress, adding structure and elegance for a sophisticated touch."
            ),
            "https://images.meesho.com/images/products/210620676/yqfoo_512.jpg" to listOf(
                "Evening Gown",
                2299,
                "Elegant evening gown, crafted to elevate formal gatherings with timeless sophistication and charm."
            ),
            "https://i0.wp.com/beyondshoping.com/wp-content/uploads/2024/02/11/1671760100.webp" to listOf(
                "Red Prom",
                2999,
                "Striking red prom dress that captures elegance and style, perfect for making a statement at special events."
            ),
            "https://curveschic.com/cdn/shop/products/4_7db00c2c-f4d0-4c53-b8e5-d4ce84efb85f.jpg?v=1647678432" to listOf(
                "V-Neck Skinny",
                3299,
                "Sophisticated skinny dress with a flattering V-neck design, tailored for a chic, modern silhouette."
            ),
            "https://www.ethnicplus.in/media/catalog/product/cache/1d5df636cf8c8988ea2d2c570bb7c21d/1/_/1_lw-9147_pink-4.jpg" to listOf(
                "Indian Prom",
                3399,
                "Graceful Indian-inspired prom gown, featuring traditional elements and a refined, luxurious finish."
            ),
            "https://assets.ajio.com/medias/sys_master/root/20240314/CORV/65f2a94a16fd2c6e6a5749a4/-473Wx593H-466316193-blue-MODEL.jpg" to listOf(
                "Square Neck Gown",
                3999,
                "Elegant square-neck gown, designed with a modern twist for standout sophistication at any formal event."
            ),
            "https://5.imimg.com/data5/SELLER/Default/2022/10/RY/VH/QC/17769549/aanaya-vol-145-art-silk-designer-party-wear-gown.jpeg" to listOf(
                "Party Wear Gown",
                3799,
                "Stylish party wear gown in art silk, balancing trendy aesthetics with a glamorous, refined look."
            ),
            "https://rukminim2.flixcart.com/image/850/1000/xif0q/dress/n/z/u/xl-tanya-green-aryane1604-original-imaghpnsbajyw7up.jpeg?q=90&crop=false" to listOf(
                "Green Gown",
                3978,
                "Eye-catching green gown with a flowing design, perfect for formal occasions with a vibrant touch."
            ),
        )
    }
}