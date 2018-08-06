package com.sog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.dao.BrandSeriesDaoI;
import com.sog.dao.BrandSeriesDaoImpl;
import com.sog.entity.Brand;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.entity.Randomnum;
import com.sog.entity.Series;
import com.sog.service.BrandsServiceI;
import com.sog.service.BrandsServiceImpl;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;
import com.sog.service.ImageCommentServiceImpl;
import com.sog.service.ImageGoodServiceI;
import com.sog.service.ImageGoodServiceImpl;
import com.sog.service.SeriesServiceI;
import com.sog.service.SeriesServiceImpl;

@WebServlet("/front/FrontIndexServlet")
public class FrontIndexServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Randomnum ran=new Randomnum();
	    BrandSeriesDaoI bsdi=new BrandSeriesDaoImpl();
		SeriesServiceI<Series> ssi = new SeriesServiceImpl();
		BrandsServiceI<Brand>  bsi =new BrandsServiceImpl();
		GoodsServiceI<Goods> gsi = new GoodsServiceImpl();
		ImageGoodServiceI<Image_goods> igsi = new ImageGoodServiceImpl();
		try {
		       int[]  rand=new int[8];//生成8位数字用来存储随机生成的序列用来随机选择brand_id
		     int[] brand_idra=new int[8];//用来存储随机顺序的brand_id
		       List brand_idlist= bsdi.findBrandAndSeries("");//获取所有拥有详细内容的brand_id
		       rand=ran.randomSet(0, brand_idlist.size()-1, 8);//生成随机数
		       List<Goods> goodlist=new ArrayList();
		       for(int i=0;i<8;i++)
				{
		    	   brand_idra[i]=(int)brand_idlist.get(rand[i]);//对brand_id进行随机打乱存入brand_idra;
		    	 
				}
		       for(int i=0;i<8;i++) {
		    	   List<Goods> golist= bsdi.findgoodsByBrand("and brand.brand_id="+brand_idra[i]);//针对随机的brand_id获取该品牌下的所有商品
		    	   int jj=golist.size();
		    	   System.out.println("该品牌共有"+jj+"个商品");
		    	   int[] j= {};
		    	   if(jj==1) {
		    		   
//		    		   System.out.println("选择第"+0+"个商品");
//			    	   System.out.println("品牌编号为"+brand_idra[i]+" aaaaaaaaaaa  商品编号为"+golist.get(0).getGoods_id());
//			    	   System.out.println("已进行了"+i);
			    	   goodlist.add(golist.get(0));
		    		   
		    	   }else {
		    		   j=ran.randomSet(0, jj, 1);//获得一个范围内的随机数
//		    		   System.out.println("选择第"+j[0]+"个商品");
//			    	   System.out.println("品牌编号为"+brand_idra[i]+" aaaaaaaaaaa  商品编号为"+golist.get(j[0]).getGoods_id());
//			    	   System.out.println("已进行了"+i);
			    	   goodlist.add(golist.get(j[0]));
		    	   }
		       }
		       
		       Image_goods[] images=new Image_goods[8];
			   List<Series> seriesList = ssi.getWhere(" ORDER BY series.sort_level DESC");	
			Series series1 = seriesList.get(0);
			Series series2 = seriesList.get(1);
			Series series3 = seriesList.get(2);
			Integer seriesId1 = series1.getSeries_id();
			Integer seriesId2 = series2.getSeries_id();
			Integer seriesId3 = series3.getSeries_id();	
			
			List<Goods> goodList1 = gsi.getWhere(" and series_id="+ seriesId1);
			List<Goods> goodList2= gsi.getWhere(" and series_id="+ seriesId2);
			List<Goods> goodList3 = gsi.getWhere(" and series_id="+ seriesId3);
			Goods goods1 = goodList1.get(0);
			Goods goods2=goodList2.get(0);
			Goods goods3=goodList3.get(0);
			List<Image_goods> imageList1 = igsi.getWhere(" and goods_id="+goods1.getGoods_id());
			List<Image_goods> imageList2 = igsi.getWhere(" and goods_id="+goods2.getGoods_id());
			List<Image_goods> imageList3 = igsi.getWhere(" and goods_id="+goods3.getGoods_id());
			Image_goods image1 = imageList1.get(0);
			Image_goods image2=  imageList2.get(0);
			Image_goods image3 = imageList3.get(0);
			request.setAttribute("Series1", series1);
			request.setAttribute("Series2", series2);
			request.setAttribute("Series3", series3);
			request.setAttribute("good1", goods1);
			request.setAttribute("good2", goods2);
			request.setAttribute("good3", goods3);
			System.out.println("第一个"+goods1.getGoods_id());
			System.out.println("第二个"+goods2.getGoods_id());
			System.out.println("第三个"+goods3.getGoods_id());
			request.setAttribute("Image1", image1);
			request.setAttribute("Image2", image2);
			request.setAttribute("Image3", image3);
			System.out.println("第一个"+image1.getRoute());
			System.out.println("第二个"+image2.getRoute());
			System.out.println("第三个"+image3.getRoute());
			request.setAttribute("GoodsArray", goodlist);
			request.getRequestDispatcher("/front/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
