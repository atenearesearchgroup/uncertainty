package org.tzi.use.uml.ocl.value;

import java.util.Iterator;
import java.util.LinkedList;

import org.tzi.use.uml.ocl.type.Type;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.util.MathUtil;

import antlr.collections.List;
import uDataTypes.*;

public final class SBooleanValue extends UncertainBooleanValue {

	public static final SBooleanValue TRUE = new SBooleanValue(1, 0, 0, 1);
	public static final SBooleanValue FALSE = new SBooleanValue(0, 1, 0, 1);

	private SBoolean sBoolean;

	SBooleanValue(double b, double d, double u, double a) {
		super(TypeFactory.mkSBoolean());
		sBoolean = new SBoolean(b, d, u, a);
	}

	SBooleanValue(SBoolean sBoolean) {
		super(TypeFactory.mkSBoolean());
		this.sBoolean = sBoolean;
	}

	public static class Builder {
		private double belief = 0;
		private double disbelief = 0;
		private double uncertainty = 0;
		private double agent = 0;

		public Builder() {
		}

		public Builder belief(double b) {
			this.belief = b;
			return this;
		}

		public Builder disbelief(double d) {
			this.disbelief = d;
			return this;
		}

		public Builder uncertainty(double u) {
			this.uncertainty = u;
			return this;
		}

		public Builder agent(double a) {
			this.agent = a;
			return this;
		}

		public SBooleanValue build() {
			SBooleanValue ret;

			if (belief == 1 && disbelief == 0 && uncertainty == 0 && agent == 1)
				ret = TRUE;
			else if (belief == 0 && disbelief == 1 && uncertainty == 0 && agent == 1)
				ret = FALSE;
			else
				ret = new SBooleanValue(belief, disbelief, uncertainty, agent);

			return ret;
		}
	}

	public static SBooleanValue valueOf(Value value) {
		SBooleanValue ret = null;

		if (value.isSBoolean()) {
			ret = (SBooleanValue) value;
		} else if (value.isUBoolean()) {
			UBooleanValue ub = (UBooleanValue) value;
			ret = new SBooleanValue(new SBoolean(ub.getuBoolean()));
		} else if (value.isBoolean()) {

			if (((BooleanValue) value).value())
				ret = TRUE;
			else
				ret = FALSE;
		} 

		return ret;
	}

	private static SBooleanValue valueOf(SBoolean sBoolean) {
		return new SBooleanValue(sBoolean);
	}

	@Override
	public boolean isSBoolean() {
		return true;
	}

	@Override
	public UncertainBooleanValue uEquals(Value other) {
		SBooleanValue result = FALSE;

		if (other.type().isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID)) {
			SBooleanValue aux = valueOf(other);
			result = valueOf(sBoolean.equivalent(aux.sBoolean));
		}

		return result;
	}

	@Override
	public UncertainBooleanValue uDistinct(Value other) {
		SBooleanValue result = TRUE;

		if (other.type().isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID)) {
			SBooleanValue aux = valueOf(other);
			result = valueOf(sBoolean.xor(aux.sBoolean));
		}

		return result;
	}

	@Override
	public StringBuilder toString(StringBuilder sb) {
		sb.append(type().toString()).append("(").append(MathUtil.round(sBoolean.belief(), 10)).append(", ")
				.append(MathUtil.round(sBoolean.disbelief(), 10)).append(", ")
				.append(MathUtil.round(sBoolean.uncertainty(), 10)).append(", ")
				.append(MathUtil.round(sBoolean.baseRate(), 10)).append(")");
		return sb;
	}

	@Override
	public int hashCode() {
		return sBoolean.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this)
			return true;

		if (!(obj instanceof SBooleanValue))
			return false;

		SBooleanValue that = (SBooleanValue) obj;
		return that.sBoolean.equals(this.sBoolean);
	}

	@Override
	public int compareTo(Value o) {
		return 0;
	}

	public static SBooleanValue assertKindOfSBoolean(Value value) {
		SBooleanValue sbool = valueOf(value);

		if (sbool == null)
			throw new RuntimeException("A value kind of SBoolean expected");

		return sbool;
	}

	// WRAPPED METHODS

	public RealValue projectiveDistance(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new RealValue(sBoolean.projectiveDistance(sBooleanValue.sBoolean));
	}

	public RealValue conjunctiveCertainty(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new RealValue(sBoolean.conjunctiveCertainty(sBooleanValue.sBoolean));
	}

	public RealValue degreeOfConflict(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new RealValue(sBoolean.degreeOfConflict(sBooleanValue.sBoolean));
	}

	public SBooleanValue uncertaintyMaximized() {
		return new SBooleanValue(sBoolean.uncertaintyMaximized());
	}

	public SBooleanValue deduceY(Value yGivenX, Value yGivenNotX) {
		SBooleanValue sboolA = assertKindOfSBoolean(yGivenX);
		SBooleanValue sboolB = assertKindOfSBoolean(yGivenNotX);
		return new SBooleanValue(sBoolean.deduceY(sboolA.sBoolean, sboolB.sBoolean));
	}

	public UBooleanValue toUBoolean() {
		return new UBooleanValue(sBoolean.toUBoolean());
	}

	public RealValue belief() {
		return new RealValue(sBoolean.belief());
	}

	public RealValue disbelief() {
		return new RealValue(sBoolean.disbelief());
	}

	public RealValue uncertainty() {
		return new RealValue(sBoolean.uncertainty());
	}

	public RealValue baseRate() {
		return new RealValue(sBoolean.baseRate());
	}

	public RealValue projection() {
		return new RealValue(sBoolean.projection());
	}

	public SBooleanValue and(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new SBooleanValue(this.sBoolean.and(sBooleanValue.sBoolean));
	}

	@Override
	public UncertainBooleanValue not() {
		return new SBooleanValue(this.sBoolean.not());
	}

	public SBooleanValue or(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new SBooleanValue(this.sBoolean.or(sBooleanValue.sBoolean));
	}

	public SBooleanValue xor(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new SBooleanValue(this.sBoolean.xor(sBooleanValue.sBoolean));
	}

	public SBooleanValue equivalent(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new SBooleanValue(this.sBoolean.equivalent(sBooleanValue.sBoolean));
	}

	public SBooleanValue implies(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new SBooleanValue(this.sBoolean.implies(sBooleanValue.sBoolean));
	}

	public RealValue getRelativeWeight() {
		return new RealValue(sBoolean.getRelativeWeight());
	}

	public BooleanValue isAbsolute() {
		return BooleanValue.get(sBoolean.isAbsolute());
	}

	public BooleanValue isVacuous() {
		return BooleanValue.get(sBoolean.isVacuous());
	}

	public BooleanValue isCertain(Value threshold) {
		RealValue v = RealValue.valueOf(threshold);
		return BooleanValue.get(sBoolean.isCertain(v.value()));
	}

	public BooleanValue isDogmatic() {
		return BooleanValue.get(sBoolean.isDogmatic());
	}

	public BooleanValue isMaximizedUncertainty() {
		return BooleanValue.get(sBoolean.isMaximizedUncertainty());
	}

	public BooleanValue isUncertain(Value threshold) {
		RealValue v = RealValue.valueOf(threshold);
		return BooleanValue.get(sBoolean.isUncertain(v.value()));
	}

	public SBooleanValue uncertainOpinion() {
		return new SBooleanValue(sBoolean.uncertaintyMaximized());
	}

	public RealValue certainty() {
		return new RealValue(sBoolean.certainty());
	}

	public static SBooleanValue createDogmaticOpinion(Value projection, Value baseRate) {
		RealValue p = RealValue.valueOf(projection);
		RealValue br = RealValue.valueOf(baseRate);
		return new SBooleanValue(SBoolean.createDogmaticOpinion(p.value(), br.value()));
	}

	public static SBooleanValue createVacuousOpinion(Value projection) {
		RealValue p = RealValue.valueOf(projection);
		return new SBooleanValue(SBoolean.createVacuousOpinion(p.value()));
	}

	public SBooleanValue minimumFusion(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();
		collection.add(this.sBoolean);
		collection.add(sBooleanValue.sBoolean);
		return new SBooleanValue(SBoolean.minimumBeliefFusion(collection));
	}

	public SBooleanValue majorityFusion(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();
		collection.add(this.sBoolean);
		collection.add(sBooleanValue.sBoolean);
		return new SBooleanValue(SBoolean.majorityBeliefFusion(collection));
	}

	public SBooleanValue averageFusion(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();
		collection.add(this.sBoolean);
		collection.add(sBooleanValue.sBoolean);
		return new SBooleanValue(SBoolean.averageBeliefFusion(collection));
	}

	public SBooleanValue cumulativeFusion(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();
		collection.add(this.sBoolean);
		collection.add(sBooleanValue.sBoolean);
		return new SBooleanValue(SBoolean.cumulativeBeliefFusion(collection));
	}

	public SBooleanValue epistemicCumulativeFusion(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();
		collection.add(this.sBoolean);
		collection.add(sBooleanValue.sBoolean);
		return new SBooleanValue(SBoolean.epistemicCumulativeBeliefFusion(collection));
	}

	public SBooleanValue weightedFusion(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();
		collection.add(this.sBoolean);
		collection.add(sBooleanValue.sBoolean);
		return new SBooleanValue(SBoolean.weightedBeliefFusion(collection));
	}

	public SBooleanValue minimumBeliefFusion(Value value) {
		CollectionValue cValue = (CollectionValue) value;
		SequenceValue seq = cValue.asSequence();
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();  collection.add(this.sBoolean);
		Iterator<Value> it = seq.iterator();
		while (it.hasNext()) {
			Value v = it.next();
			SBooleanValue sBooleanValue = assertKindOfSBoolean(v);
			collection.add(sBooleanValue.sBoolean);
		}
		return new SBooleanValue(SBoolean.minimumBeliefFusion(collection));
	}
	
	public SBooleanValue majorityBeliefFusion(Value value) {
		CollectionValue cValue = (CollectionValue) value;
		SequenceValue seq = cValue.asSequence();
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();  collection.add(this.sBoolean);
		Iterator<Value> it = seq.iterator();
		while (it.hasNext()) {
			Value v = it.next();
			SBooleanValue sBooleanValue = assertKindOfSBoolean(v);
			collection.add(sBooleanValue.sBoolean);
		}
		return new SBooleanValue(SBoolean.majorityBeliefFusion(collection));
	}
	
	public SBooleanValue beliefConstraintFusion(Value value) {
		CollectionValue cValue = (CollectionValue) value;
		SequenceValue seq = cValue.asSequence();
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>(); collection.add(this.sBoolean);
		Iterator<Value> it = seq.iterator();
		while (it.hasNext()) {
			Value v = it.next();
			SBooleanValue sBooleanValue = assertKindOfSBoolean(v);
			collection.add(sBooleanValue.sBoolean);
		}
		return new SBooleanValue(uDataTypes.SBoolean.beliefConstraintFusion(collection));
	}
	
	public SBooleanValue averageBeliefFusion(Value value) {
		CollectionValue cValue = (CollectionValue) value;
		SequenceValue seq = cValue.asSequence();
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>(); collection.add(this.sBoolean);
		Iterator<Value> it = seq.iterator();
		while (it.hasNext()) {
			Value v = it.next();
			SBooleanValue sBooleanValue = assertKindOfSBoolean(v);
			collection.add(sBooleanValue.sBoolean);
		}
		return new SBooleanValue(SBoolean.averageBeliefFusion(collection));
	}
	
	public SBooleanValue aleatoryCumulativeBeliefFusion(Value value) {
		CollectionValue cValue = (CollectionValue) value;
		SequenceValue seq = cValue.asSequence();
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();  collection.add(this.sBoolean);
		Iterator<Value> it = seq.iterator();
		while (it.hasNext()) {
			Value v = it.next();
			SBooleanValue sBooleanValue = assertKindOfSBoolean(v);
			collection.add(sBooleanValue.sBoolean);
		}
		return new SBooleanValue(SBoolean.cumulativeBeliefFusion(collection));
	}
	
	public SBooleanValue epistemicCumulativeBeliefFusion(Value value) {
		CollectionValue cValue = (CollectionValue) value;
		SequenceValue seq = cValue.asSequence();
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();  collection.add(this.sBoolean);
		Iterator<Value> it = seq.iterator();
		while (it.hasNext()) {
			Value v = it.next();
			SBooleanValue sBooleanValue = assertKindOfSBoolean(v);
			collection.add(sBooleanValue.sBoolean);
		}
		return new SBooleanValue(SBoolean.epistemicCumulativeBeliefFusion(collection));
	}
	
	public SBooleanValue weightedBeliefFusion(Value value) {
		CollectionValue cValue = (CollectionValue) value;
		SequenceValue seq = cValue.asSequence();
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();  collection.add(this.sBoolean);
		Iterator<Value> it = seq.iterator();
		while (it.hasNext()) {
			Value v = it.next();
			SBooleanValue sBooleanValue = assertKindOfSBoolean(v);
			collection.add(sBooleanValue.sBoolean);
		}
		return new SBooleanValue(SBoolean.weightedBeliefFusion(collection));
	}
	
	public SBooleanValue concensusAndCompromiseFusion(Value value) {
		CollectionValue cValue = (CollectionValue) value;
		SequenceValue seq = cValue.asSequence();
		LinkedList<SBoolean> collection = new LinkedList<SBoolean>();  collection.add(this.sBoolean);
		Iterator<Value> it = seq.iterator();
		while (it.hasNext()) {
			Value v = it.next();
			SBooleanValue sBooleanValue = assertKindOfSBoolean(v);
			collection.add(sBooleanValue.sBoolean);
		}
		return new SBooleanValue(SBoolean.concensusAndCompromiseFusion(collection));
	}

	public SBooleanValue min(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new SBooleanValue(this.sBoolean.min(sBooleanValue.sBoolean));
	}

	public SBooleanValue max(Value value) {
		SBooleanValue sBooleanValue = assertKindOfSBoolean(value);
		return new SBooleanValue(this.sBoolean.max(sBooleanValue.sBoolean));
	}

}
