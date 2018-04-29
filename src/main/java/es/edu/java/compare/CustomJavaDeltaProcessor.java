package es.edu.java.compare;

import java.lang.reflect.Field;

import es.edu.java.utils.GraphComparator;
import es.edu.java.utils.GraphComparator.Delta;
import es.edu.java.utils.GraphComparator.DeltaProcessor;

public class CustomJavaDeltaProcessor implements DeltaProcessor {

	@Override
	public void processArraySetElement(Object srcValue, Field field, Delta delta) {
        System.out.println("Using default implementation");
		GraphComparator.getJavaDeltaProcessor().processArraySetElement(srcValue, field, delta);
	}

	@Override
	public void processArrayResize(Object srcValue, Field field, Delta delta) {
		GraphComparator.getJavaDeltaProcessor().processArrayResize(srcValue, field, delta);
	}

	@Override
	public void processObjectAssignField(Object srcValue, Field field, Delta delta) {
		GraphComparator.getJavaDeltaProcessor().processObjectAssignField(srcValue, field, delta);
	}

	@Override
	public void processObjectOrphan(Object srcValue, Field field, Delta delta) {
        System.out.println(delta);
	}

	@Override
	public void processObjectTypeChanged(Object srcValue, Field field, Delta delta) {
		System.out.println("Using default implementation");
		GraphComparator.getJavaDeltaProcessor().processObjectTypeChanged(srcValue, field, delta);
	}

	@Override
	public void processSetAdd(Object srcValue, Field field, Delta delta) {
		System.out.println("Using default implementation");
		GraphComparator.getJavaDeltaProcessor().processSetAdd(srcValue, field, delta);
	}

	@Override
	public void processSetRemove(Object srcValue, Field field, Delta delta) {
		System.out.println("Using default implementation");
		GraphComparator.getJavaDeltaProcessor().processSetRemove(srcValue, field, delta);
	}

	@Override
	public void processMapPut(Object srcValue, Field field, Delta delta) {
		System.out.println("Using default implementation");
		GraphComparator.getJavaDeltaProcessor().processMapPut(srcValue, field, delta);
	}

	@Override
	public void processMapRemove(Object srcValue, Field field, Delta delta) {
		System.out.println("Using default implementation");
		GraphComparator.getJavaDeltaProcessor().processMapRemove(srcValue, field, delta);
	}

	@Override
	public void processListResize(Object srcValue, Field field, Delta delta) {
		System.out.println("Using default implementation");
		GraphComparator.getJavaDeltaProcessor().processListResize(srcValue, field, delta);
	}

	@Override
	public void processListSetElement(Object srcValue, Field field, Delta delta) {
		System.out.println("Using default implementation");
		GraphComparator.getJavaDeltaProcessor().processListSetElement(srcValue, field, delta);
	}

}