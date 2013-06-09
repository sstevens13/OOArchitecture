package broker;

/*
 * parameters are strings or integers (integers are comma separated)
 * parameterTypes are "string" or "integer"
 */
public class CallMessage {
	private String target;
	private String source;
	private String methodName;
	private String parameters;	// parameters of method, or returned value
	private String parameterTypes; 
	
	public CallMessage(String target, String source, String methodName, String parameters, String parameterTypes) {
		this.target = target;
		this.source = source;
		this.methodName = methodName;
		this.parameters = parameters;
		this.parameterTypes = parameterTypes;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public String getParameters() {
		return parameters;
	}
	
	public String getParameterTypes() {
		return parameterTypes;
	}	
	
	public String getTarget() {
		return target;
	}
	
	public String getSource() {
		return source;
	}
}
