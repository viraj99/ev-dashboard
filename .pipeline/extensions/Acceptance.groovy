import static com.sap.piper.internal.Prerequisites.checkScript

void call(Map params) {
	node{
	echo "do acceptance stage"
	echo "Cloning deployment config repository.."
	checkout([
		$class: 'GitSCM',
		extensions: [
			[$class: 'RelativeTargetDirectory', relativeTargetDir: "deployment"],
		],
		userRemoteConfigs: [
			[credentialsId: 'GitHub-emobility-ci-build', url: "https://github.wdf.sap.corp/EVSE/ev-scp-sap-it.git"]
		]
		])
	sh "ls"
	sh "ls deployment"
	sh "cp -pr ./deployment/e-Mobility-dev/sap-ev-front-end-server/* ."
	sh "ls"
	sh "ls src/assets"

	//params.originalStage()

}
return this
