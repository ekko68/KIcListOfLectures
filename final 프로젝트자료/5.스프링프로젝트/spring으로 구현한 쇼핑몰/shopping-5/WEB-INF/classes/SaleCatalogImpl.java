package logic;

import java.util.Iterator;
import java.util.List;

import dao.SaleDao;
import dao.SaleLineDao;

public class SaleCatalogImpl implements SaleCatalog {
	
	private SaleDao saleDao;

	private SaleLineDao saleLineDao;

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}
	
	public void setSaleLineDao(SaleLineDao saleLineDao) {
		this.saleLineDao = saleLineDao;
	}

	public void entrySale(Sale sale) {
		
		this.saleDao.create(sale);
		
		List saleLineList = sale.getSaleLineList();
		for(Iterator it = saleLineList.iterator(); it.hasNext();){
			
			SaleLine saleLine = (SaleLine)it.next();
			this.saleLineDao.create(saleLine);
		}
	}

	public Integer getNewSaleId() {
		int newSaleId = this.saleDao.findMaxSaleId().intValue() + 1;
		return new Integer(newSaleId);
	}
}