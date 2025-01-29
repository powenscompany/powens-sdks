Pod::Spec.new do |spec|
    spec.name                     = 'PowensConnect'
    spec.version                  = '1.0.0-beta'
    spec.homepage                 = 'https://www.powens.com'
    spec.source                   = { :git => 'https://github.com/powenscompany/powens-connect-ios.git', :tag => '1.0.0-beta' }
    spec.authors                  = 'Powens'
    spec.license                  = { :type => 'LGPLv3' }
    spec.summary                  = 'Ready-made tools to connect with Powens APIs and easily implement aggregation journeys'
    spec.vendored_frameworks      = 'build/cocoapods/framework/PowensConnect.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target    = '14.1'
                
                
    if !Dir.exist?('build/cocoapods/framework/PowensConnect.framework') || Dir.empty?('build/cocoapods/framework/PowensConnect.framework')
        raise "

        Kotlin framework 'PowensConnect' doesn't exist yet, so a proper Xcode project can't be generated.
        'pod install' should be executed after running ':generateDummyFramework' Gradle task:

            ./gradlew :lib:generateDummyFramework

        Alternatively, proper pod installation is performed during Gradle sync in the IDE (if Podfile location is set)"
    end
                
    spec.xcconfig = {
        'ENABLE_USER_SCRIPT_SANDBOXING' => 'NO',
    }
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':lib',
        'PRODUCT_MODULE_NAME' => 'PowensConnect',
    }
                
    spec.script_phases = [
        {
            :name => 'Build PowensConnect',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
    spec.resources = ['build\compose\cocoapods\compose-resources']
end