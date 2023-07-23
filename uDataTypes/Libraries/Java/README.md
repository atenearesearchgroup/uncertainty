# Uncertainty Java Library

Uncertainty is an inherent property of any measure or estimation performed in any physical setting, and therefore it needs to be considered when modeling systems that manage real data. Although several modeling languages permit the representation of measurement uncertainty for describing some system attributes, these aspects are not normally incorporated into their type systems. Thus, operating with uncertain values and propagating uncertainty are normally cumbersome processes, difficult to achieve at the model level. This library provides an extension of Python basic datatypes to incorporate data uncertainty coming from physical measurements or user estimations into the models, along with the set of operations defined for the values of these types.

This Java library supports an extension of the UML/OCL primitive datatypes with uncertainty, including ``UBoolean``, ``SBoolean``, ``UReal``, ``UInteger``, ``UnlimitedNatural``. This library of Java classes implements linear error propagation theory in Java.

Uncertain numerical values,  ``UReal`` and ``UInteger``, are represented by pairs ``(x,u)`` where ``x`` is the numerical (nominal) value and ``u`` is its associated uncertainty. For example, ``UReal(3.5,0.1)`` represents the uncertain real number 3.5 +/- 0.1, and ``UInteger(30,1)`` represents the uncertain integer 30 +/- 1. 

This representation of uncertainty for numerical values follows the "ISO Guide to Measurement Uncertainty" ([JCMG 100:2008](https://www.bipm.org/documents/20126/2071204/JCGM_100_2008_E.pdf)), where values are represented by the mean and standard deviation of the assumed probability density function representing how measurements of ground truth values are distributed. For example, if we assume that the values of a variable X follow a normal distribution N(x, σ), then we set u = σ. If we can only assume a uniform or rectangular distribution of the possible values of X, then x is taken as the midpoint of the interval, x = (a + b)/2, and its associated standard deviation as u = (b - a)/(2 * sqrt(3)).

Type ``UBoolean`` extends type ``Boolean`` by using propabilities instead of the traditional logical truth values (True, False), and by replacing truth tables by probability expressions. Thus, an ``UBoolean`` value is expressed by a probability representing the degree of belief (i.e., the *confidence*) that a given statement is true. For example, ``UBoolean(true,0.7)`` means that there is a 70% chance of an event occurring. Boolean values ``true`` and ``false`` correspond to ``UBoolean(true,1.0)`` and ``UBoolean(true, 0.0)``, respectively.  

Type ``SBoolean`` provides an extension of ``UBoolean`` to represent binomial *opinions* in [Subjective Logic](https://en.wikipedia.org/wiki/Subjective_logic). They allow expressing degrees of belief with epistemic uncertainty, and also trust. A binomial opinion about a given fact X by a belief agent A is represented as a quadruple ``SBoolean(b,d,u,a)`` where

- ``b`` is the degree of belief that X is True
- ``d`` is the degree of belief that X is False
- ``u`` is the amount of uncommitted belief, also interpreted as epistemic uncertainty.
- ``a`` is the prior probability in the absence of belief or disbelief.

These values are all real numbers in the range [0,1] and satisfy that *b+d+u=1*. The "*projected*" probability of a binomial opinion is defined as *P=b+au*. 

### Supported operations

All most common operations and Mathematical functions on these datatypes are supported.

More precisely,

    TYPE UReal 
    -- Constructor 
    UReal(x:Real,u:Real)
    -- Getters and setters
    UReal.value() : Real
    UReal.uncertainty() : Real
    -- OPERATIONS
    UReal.abs() : UReal
    UReal.neg() : UReal
    UReal + Number (Integer | Real | UReal) : UReal
    UReal - Number : UReal
    UReal * Number : UReal
    UReal / Number : UReal
    UReal.power(n : Number) : UReal
    UReal.sqrt() : UReal
    UReal.floor() : UReal
    UReal.round() : UReal
    UReal.inv() : UReal
    UReal.sin() : UReal
    UReal.cos() : UReal
    UReal.tan() : UReal
    UReal.asin() : UReal
    UReal.acos() : UReal
    UReal.atan() : UReal
    UReal.min(n : Number) : UReal
    UReal.max(n : Number) : UReal
    -- COMPARISONS
    UReal = Number : UBoolean
    UReal <> Number : UBoolean
    UReal < Number : UBoolean
    UReal > Number : UBoolean
    UReal <= Number : UBoolean
    UReal >= Number : UBoolean
    UReal.equals() : Boolean
    -- CONVERSIONS
    UReal.toInteger() : Integer
    UReal.toReal() : Real
    UReal.toString() : String


    TYPE UInteger
    --constructor
    UInteger(n:Integer, u:Real)
    -- Getters and setters
    UInteger.value() : Integer
    UInteger.uncertainty() : Real
    -- OPERATIONS
    UInteger .abs() : UInteger
    UInteger .neg() : UInteger
    UInteger + Number : UInteger | UReal (it depends on the common supertype)
    UInteger - Number : UInteger | UReal (it depends on the common supertype)
    UInteger * Number : UInteger | UReal (it depends on the common supertype)
    UInteger / Number : UReal
    UInteger.div(Number) : UInteger
    UInteger.mod(Number) : UInteger
    UInteger.power(n : Number) : UReal
    UInteger.sqrt() : UReal
    -- COMPARISONS
    UInteger = Number : UBoolean
    UInteger <> Number : UBoolean
    UInteger < Number : UBoolean
    UInteger > Number : UBoolean
    UInteger <= Number : UBoolean
    UInteger >= Number : UBoolean
    UReal.equals(OclAny) : Boolean
    -- CONVERSIONS
    UInteger.toUReal() : UReal
    UInteger.toString() : String
    UInteger.toInteger() : Integer
    UInteger.toReal() : Real

    TYPE UBoolean
    -- constructor, 0<=c<=1 -> Otherwise it is "Undefined"
    UBoolean(b:Boolean, c:Real) 
    -- Getters and setters
    UBoolean.value() : Boolean
    UBoolean.confidence() : Real
    UBoolean.uncertainty() : Real -- same as "confidence()", for consistency
    -- OPERATIONS
    UBoolean.and(UBoolean) : UBoolean
    UBoolean.or(UBoolean) : UBoolean
    UBoolean.not(UBoolean) : UBoolean
    UBoolean.implies(UBoolean) : UBoolean
    UBoolean.xor(UBoolean) : UBoolean
    UBoolean.equivalent(UBoolean) : UBoolean
    -- COMPARISONS
    UBoolean.equalsC(UBoolean, c:Real) : Boolean -- provide the threshold confidence
    UBoolean.equals(OclAny) : Boolean
    UBoolean = (UBoolean | Boolean) : UBoolean
    UBoolean <> (UBoolean | Boolean) : UBoolean
    -- CONVERSIONS
    UBoolean.toBoolean() : Boolean
    UBoolean.toBooleanC(c:Real) : Boolean -- provide the threshold confidence
    UBoolean.toString() : String


    TYPE SBoolean
    -- constructors, b+d+u=1, 0<=b<=1, 0<=d<=1, 0<=u<=1, 0<=a<=1 
    SBoolean(b:Boolean) -- same as SBoolean(1,0,0,1) or SBoolean(0,1,0,0) -- "Absolute" opinions
    SBoolean(b:UBoolean) -- "Dogmatic" opinions, with u==0
    SBoolean(b:Real, d:Real, u:Real, a:Real) 
    -- Getters (no setters allowed for this type)
    SBoolean.belief() : Real
    SBoolean.disbelief() : Real
    SBoolean.uncertainty() : Real
    SBoolean.baseRate() : Real
    -- Queries
    SBoolean.isAbsolute() : Boolean     -- belief = 1 or disbelief = 1
    SBoolean.isVacuous () : Boolean   -- uncertainty = 1
    SBoolean.isDogmatic () : Boolean -- uncertainty = 0
    SBoolean.isMaximizedUncertainty () : Boolean     -- belief = 0 or disbelief = 0
    SBoolean.certainty() : Boolean     -- 1.0-uncertainty (== belief+disbelief)
    SBoolean.isUncertain(th:Real) : Boolean     -- self.certainty() < th

    -- OPERATIONS
    SBoolean.projection() : Real
    SBoolean.projectiveDistance() : Real
    SBoolean.conjunctiveCertainty() : Real
    SBoolean.degreeOfConflict() : Real
    SBoolean.not() : SBoolean
    SBoolean.uncertaintyMaximized() : SBoolean -- result.isMaximizedUncertainty()
    SBoolean.and(SBoolean) : SBoolean
    SBoolean.or(SBoolean) : SBoolean
    SBoolean.implies(SBoolean) : SBoolean
    SBoolean.xor(SBoolean) : SBoolean
    SBoolean.equivalent(SBoolean) : SBoolean
    SBoolean.deduceY(yGivenX:SBoolean, yGivenNotX:SBoolean)

    -- COMPARISONS
    SBoolean.equals(OclAny) : Boolean
    SBoolean = (SBoolean | UBoolean | Boolean) : SBoolean -- same as equivalent
    SBoolean <> (SBoolean | UBoolean | Boolean) : SBoolean -- same as xor
    SBoolean.min(SBoolean):SBoolean
    SBoolean.max(SBoolean):SBoolean
    -- CONVERSIONS
    SBoolean.toUBoolean() : UBoolean
    SBoolean.toString() : String
    -- "Type" (static) operations:
    ?SBoolean.minimumBeliefFusion(sb1,sb2,sb3)
    ?SBoolean.majorityBeliefFusion(sb1,sb2,sb3)
    ?SBoolean.beliefConstraintFusion(sb1,sb2,sb3)
    ?SBoolean.averageBeliefFusion(sb1,sb2,sb3)
    ?SBoolean.aleatoryCumulativeBeliefFusion(sb1,sb2,sb3)
    ?SBoolean.epistemicCumulativeBeliefFusion(sb1,sb2,sb3)
    ?SBoolean.weightedBeliefFusion(sb1,sb2,sb3)
    ?SBoolean.consensusAndCompromiseFusion(sb1,sb2,sb3)

    -- BINARY FUSION OPERATORS
    ?sb1.minimumFusion(sb2)                -- minimumBeliefFusion(sb1,sb2)
    ?sb1.majorityFusion(sb2)               -- majorityBeliefFusion(sb1,sb2)
    ?sb1.beliefConstraintFusion(sb2)       -- beliefConstraintBeliefFusion(sb1,sb2)
    ?sb1.averageBeliefFusion(sb2)                -- averageBeliefFusion(sb1,sb2)
    ?sb1.aleatoryCumulativeFusion(sb2)     -- aleatoryCumulativeBeliefFusion(sb1,sb2)
    ?sb1.epistemicCumulativeFusion(sb2)    -- epistemicCumulativeBeliefFusion(sb1,sb2)
    ?sb1.weightedBeliefFusion(sb2)               -- weightedBeliefFusion(sb1,sb2)
    ?sb1.consensusAndCompromiseFusion(sb2) -- consensusAndCompromiseBeliefFusion(sb1,sb2)

    -- COLLECTION FUSION OPERATIONS 
    ?sb1.minimumBeliefFusion(Sequence{sb2, sb3})               -- minimumBeliefFusion(sb1,sb2,sb3)
    ?sb1.majorityBeliefFusion(Sequence{sb2, sb3})              -- majorityBeliefFusion(sb1,sb2,sb3)
    ?sb1.beliefConstraintFusion(Sequence{sb2, sb3})            -- beliefConstraintFusion(sb1,sb2,sb3)
    ?sb1.averageBeliefFusion(Sequence{sb2, sb3})               -- averageBeliefFusion(sb1,sb2,sb3)
    ?sb1.aleatoryCumulativeBeliefFusion(Sequence{sb2, sb3})    -- aleatoryCumulativeBeliefFusion(sb1,sb2,sb3)
    ?sb1.epistemicCumulativeBeliefFusion(Sequence{sb2, sb3})   -- epistemicCumulativeBeliefFusion(sb1,sb2,sb3)
    ?sb1.weightedBeliefFusion(Sequence{sb2, sb3})              -- weightedBeliefFusion(sb1,sb2,sb3)
    ?sb1.consensusAndCompromiseFusion(Sequence{sb2, sb3})      -- consensusAndCompromiseFusion(sb1,sb2,sb3)


    TYPE UString
    -- constructor, 0<=c<=1 
    UString(s:String, c:Real) 
    -- Getters and setters
    UString.value() : String
    UString.confidence() : Real
    UString.setValue(String) : UString
    UString.setConfidence(Real) : UString
    -- OPERATIONS
    UString.at(Integer) : UString
    UString.character() : Sequence(UString)
    UString + (UString | String) : UString
    UString.size() : UInteger
    UString.indexOf(String) : UString
    UString.substring(Integer, Integer) : UString
    UString.toLowerCase() : UString
    UString.toUpperCase() : UString
    -- COMPARISONS
    UString == Value : UBoolean
    UString <> Value : UBoolean
    UString > Value : UBoolean
    UString >= Value : UBoolean
    UString < Value : UBoolean
    UString <= Value : UBoolean
    UString.equals(Value) : Boolean
    -- CONVERSIONS
    UString.toReal() : Real
    UString.toInteger() : Integer
    UString.toBoolean() : Boolean
    UString.toUBoolean() : UBoolean
    UString.toString() : String


## Main features

This library provides a simple implementation of uncertainty for UML/OCL primitive datatypes, and implements linear error propagation theory in Java.
Our goal was to support the basic mechanisms for the expression and propagation of uncertainty, in a lightweight and efficient manner. 

A distinguishing feature of this library is that comparison operators return ``UBoolean`` values. This is not supported by the rest of the related uncertainty libraries, such as [uncertainties package](https://pythonhosted.org/uncertainties), [soerp](https://pypi.python.org/pypi/soerp) or [mcerp](https://pypi.python.org/pypi/mcerp).

Unlike in these other packages, correlations between expressions are not automatically taken into account in this library. This saves keeping track at all times of all correlations between quantities (variables and functions), improving the performance of the calculations. However, this implies that, ***by default, we assume that variables are independent***. Among other things, this means that users are expected to simplify numerical expressions as much as possible in order to avoid duplication of uncertain variables.

In any case, should there be a need to deal with dependent variables, ``UInteger`` and ``UReal`` mathematical operations allow specifying the correlation between them.

The derivatives of mathematical expressions are not automatically handled by this library. Again, this saves keeping track of the value of derivatives and automatically obtaining them, something that also impacts performance. Other unsuported features include automatic handling of arrays of uncertain numbers, or higher-order analysis to error propagation.

There are more powerful libraries that provide these features. 
 
 - For example, the [uncertainties package](https://pythonhosted.org/uncertainties) provides full support for uncertainty progagation, variable correlation, derivatives, and integration with the [NumPy](https://numpy.org/) package for scientific computation in Python. Most uncertainty calculations are performed analytically.
  
 - [soerp](https://pypi.python.org/pypi/soerp) is another uncertainty calculation package for Python that provides higher-order approximations of uncertainty. In particular, it supports a second-order analysis to error propagation. Advanced mathematical functions, similar to those in the standard [math](http://docs.python.org/library/math.html) module can also be evaluated directly.

-  [mcerp](https://pypi.python.org/pypi/mcerp) provides a stochastic calculator for Monte Carlo methods that uses 
latin-hypercube sampling to perform non-order specific 
error propagation (or uncertainty analysis).

The problem is that these implementations are sometimes too slow, e.g., when used in iterative methods, and their comparison operations are not expressive enough -- that is, the return *crisp* boolean values. This library tries to address these limitations.

In summary, the uncertain datatypes provided by this library is well suited for applications that require simple mechanisms for the propagation of uncertainty, efficient computation, and a closed algebra of datatypes (e.g., the comparison of two uncertain numeric values returns a probability, i.e., a ``UBoolean`` value).  


## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT Licence](https://choosealicense.com/licenses/mit/)

Copyright (c) 2023 Atenea Research group.

*Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:*

*The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.*

## Version control

This is the first version of this Java library (September 2023).

---

## References and further information


The following papers contain all the details about these datatypes:

- Manuel F. Bertoa, Loli Burgueño, Nathalie Moreno, Antonio Vallecillo. "Incorporating measurement uncertainty into OCL/UML primitive datatypes" Softw. Syst. Model. 19(5):1163-1189, 2020. https://doi.org/10.1007/s10270-019-00741-0
- Paula Muñoz, Loli Burgueño, Victor Ortiz, Antonio Vallecillo. "Extending OCL with Subjective Logic" J. Object Technol. 19(3): 3:1-15, 2020. https://doi.org/10.5381/jot.2020.19.3.a1

Examples of applications of the uncertainty datatypes presented here can be found in the following papers:

- Jean-Marc Jézéquel, Antonio Vallecillo. "Uncertainty-aware Simulation of Adaptive Systems"  ACM Transactions on Modeling and Computer Simulation, 33(3):8:1-8:19, 2023. https://doi.org/10.1145/3589517

- Lola Burgueño, Paula Muñoz, Robert Clarisó, Jordi Cabot, Sébastien Gérard, Antonio Vallecillo. "Dealing with Belief Uncertainty in Domain Models" ACM Trans. Softw. Eng. Methodol. 32(2):31:1-31:34, 2023. https://doi.org/10.1145/3542947
- Francisco J. Navarrete, Antonio Vallecillo.
"Introducing Subjective Knowledge Graphs" In Proc. of EDOC 2021. pp. 61-70, 2021. https://doi.org/10.1109/EDOC52215.2021.00017
- 	Nathalie Moreno, Manuel F. Bertoa, Loli Burgueño, Antonio Vallecillo. "Managing Measurement and Occurrence Uncertainty in Complex Event Processing Systems" IEEE Access 7:88026-88048, 2019. https://doi.org/10.1109/ACCESS.2019.2923953
- Victor Ortiz, Loli Burgueño, Antonio Vallecillo, Martin Gogolla. "Native Support for UML and OCL Primitive Datatypes Enriched with Uncertainty in USE" In Proc. of OCL@MoDELS 2019:59-66, 2019. https://ceur-ws.org/Vol-2513/paper5.pdf 
- Nathalie Moreno, Manuel F. Bertoa, Gala Barquero, Loli Burgueño, Javier Troya, Adrián García-López, Antonio Vallecillo. "Managing Uncertain Complex Events in Web of Things Applications". In Proc. of ICWE 2018:349-357, 2018. https://doi.org/10.1007/978-3-319-91662-0_28
- Loli Burgueño, Manuel F. Bertoa, Nathalie Moreno, Antonio Vallecillo. "Expressing Confidence in Models and in Model Transformation Elements" In Proc. of MoDELS 2018: 57-66, 2018. https://doi.org/10.1145/3239372.3239394
 


For more information, please visit our research group's websites: 
- [Atenea Research Group](http://atenea.lcc.uma.es/) 
- [Atenea: Uncertain UML/OCL Types](http://atenea.lcc.uma.es/projects/UncertainOCLTypes.html) 
- [Atenea: Subjective Logic](http://atenea.lcc.uma.es/projects/SubjectiveLogic.html)


---
