File path: src/jorphan/org/apache/jorphan/gui/RateRenderer.java
Comment: // TODO: should this just call super()?
Initial commit id: bb63ad9f5
Final commit id: 2633ade66
   Bugs between [       0]:

   Bugs after [       0]:


Start block index: 20
End block index: 42
	public void setValue(Object value) {
		if (value == null || ! (value instanceof Double)) {
			setText("#N/A"); // TODO: should this just call super()?
			return;
		}
		double rate = ((Double) value).doubleValue();
		if (rate == Double.MAX_VALUE){
			setText("#N/A"); // TODO: should this just call super()?
			return;
		}
		
	    String unit = "sec";

	    if (rate < 1.0) {
	        rate *= 60.0;
	        unit = "min";
	    }
	    if (rate < 1.0) {
	        rate *= 60.0;
	        unit = "hour";
	    }			
	    setText(formatter.format(rate) + "/" + unit);
	}
