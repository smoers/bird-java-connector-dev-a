package org.bird.db.object.infinispan;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.hibernate.search.bridge.FieldBridge;
import org.hibernate.search.bridge.LuceneOptions;
import org.joda.time.DateTime;


public class JodaTimeSplitBridge implements FieldBridge {

	@Override
	public void set(String name, Object value, Document document, LuceneOptions luceneoptions) {

		DateTime datetime = (DateTime) value;
		int year = datetime.getYear();
		int month = datetime.getMonthOfYear();
		int day = datetime.getDayOfMonth();
		
		// set year
		luceneoptions.addFieldToDocument(name+".year",String.valueOf(year), document);
		
		// set month
		luceneoptions.addFieldToDocument(name+".month", month < 10 ? "0" : "" + String.valueOf(month), document);

		// set day
		luceneoptions.addFieldToDocument(name+".day", day < 10 ? "0" : "" + String.valueOf(day), document);

	}

}
